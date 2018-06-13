package hello.controller;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.gimpy.FishEyeGimpyRenderer;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private static int captchaExpires = 3 * 60; // 超时时间3min
	private static int captchaW = 200;
	private static int captchaH = 60;

	@RequestMapping(value = "/getCaptcha", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getCaptcha(HttpServletResponse response) {
		// 生成验证码
		String uuid = UUID.randomUUID().toString();

		Captcha captcha = new Captcha.Builder(captchaW, captchaH).addText()
				.addBackground(new GradiatedBackgroundProducer(Color.orange, Color.white))
				.gimp(new FishEyeGimpyRenderer()).build();
		System.out.println("验证码为" + captcha.getAnswer());
		System.out.println("uuid : " + uuid);
		// 将验证码以<key,value>形式缓存到redis
		redisTemplate.opsForValue().set(uuid, captcha.getAnswer(), captchaExpires, TimeUnit.SECONDS);

		// 将验证码key，及验证码的图片返回
		Cookie cookie = new Cookie("CaptchaCode", uuid);
		response.addCookie(cookie);
		response.addHeader("CaptchaCode", uuid);
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		try {
			ImageIO.write(captcha.getImage(), "png", bao);
			return bao.toByteArray();
		} catch (IOException e) {
			return null;
		}
	}

	@GetMapping("login")
	public ResponseEntity<Object> login(@RequestParam String verifyCode,
			@RequestHeader("CaptchaCode") String captchaCode) {
		ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
		String code = (String)opsForValue.get(captchaCode);
		//String code = opsForValue.get(captchaCode).toString();
		
		if (StringUtils.isNotBlank(code) && verifyCode.equals(code)) {
			return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}

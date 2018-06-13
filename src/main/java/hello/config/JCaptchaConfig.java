package hello.config;

import org.springframework.context.annotation.Configuration;

import com.octo.captcha.engine.CaptchaEngine;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;

@Configuration
public class JCaptchaConfig extends DefaultManageableImageCaptchaService{

	@Override
	public void setCaptchaEngine(CaptchaEngine engine) {
		// TODO Auto-generated method stub
		super.setCaptchaEngine(engine);
	}

	
}

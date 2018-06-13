package hello.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class Holiday {

	public static void main(String[] agrs) {
		LocalDate today = LocalDate.now();
		//System.out.println(today);
		LocalDate payDate = today.with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);
		//System.out.println(payDate);
		
		LocalDate  dateofBirth = LocalDate.of(1992, Month.MARCH, 6);
		LocalDate birthday = dateofBirth.plusYears(26);
		System.out.println(birthday);
	}
}

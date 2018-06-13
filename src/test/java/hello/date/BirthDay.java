package hello.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import org.junit.Test;

public class BirthDay {

	public static void main(String[] args) {
		//localDate();
		//yearMonth();
		monthDay();
		
	}
	
	public static void day() {
		//System.out.format("%s%n", DayOfWeek.MONDAY.plus(3));
				//DayOfWeek dow = DayOfWeek.MONDAY;
				//Locale locale = Locale.getDefault();
				//System.out.println(dow.getDisplayName(TextStyle.FULL, locale));
				//System.out.println(dow.getDisplayName(TextStyle.NARROW, locale));
				//System.out.println(dow.getDisplayName(TextStyle.SHORT, locale));
	}
	
	public static void month() {
		//System.out.printf("%s%n", Month.FEBRUARY.maxLength());
		Month month = Month.AUGUST;
		Locale locale = Locale.getDefault();
		System.out.println(month.getDisplayName(TextStyle.FULL, locale));
		System.out.println(month.getDisplayName(TextStyle.NARROW, locale));
		System.out.println(month.getDisplayName(TextStyle.SHORT, locale));
	}
	
	public static void localDate() {
		LocalDate date = LocalDate.of(2018, Month.JUNE, 12);
		//System.out.printf("%s%n", date);
		//LocalDate nextMon = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		//System.out.print(nextMon);
		//DayOfWeek dotw = LocalDate.of(2018, Month.JULY, 7).getDayOfWeek();
		TemporalAdjuster adjuster = TemporalAdjusters.next(DayOfWeek.MONDAY);
		LocalDate nextMon = date.with(adjuster);
		System.out.printf("for the date of %s, the next Monday is %s %n", date, nextMon);
	}
	
	public static void yearMonth() {
		YearMonth now = YearMonth.now();
		System.out.printf("%s: %d%n", now, now.lengthOfMonth());
		
		YearMonth date = YearMonth.of(2017, Month.FEBRUARY);
		System.out.printf("%s: %d%n", date, date.lengthOfMonth());
		
		YearMonth date1 = YearMonth.of(2012, Month.FEBRUARY);
		System.out.printf("%s: %d%n", date1, date1.lengthOfMonth());
	}
	
	public static void monthDay() {
		MonthDay date = MonthDay.of(Month.FEBRUARY, 29);
		boolean validYear = date.isValidYear(2016);
		System.out.print(validYear);
	}
	
	@Test
	public void year() {
		boolean leap = Year.of(2016).isLeap();
		System.out.println(leap);
	}
	
	@Test
	public void localTime() {
		LocalTime now = LocalTime.now();
		System.out.println(now);
	}
	
}








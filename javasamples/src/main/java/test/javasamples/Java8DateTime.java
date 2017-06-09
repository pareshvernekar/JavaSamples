package test.javasamples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Java8DateTime {

	public static void main(String[] argv) {
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		OffsetDateTime offsetDateTime = OffsetDateTime.now();
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
		System.out.println("LocalDate:"+localDate);
		System.out.println("LocalTime:"+localTime);
		System.out.println("LocalDateTime:"+localDateTime);
		System.out.println("OffsetDateTime:"+offsetDateTime);
		System.out.println("ZonedDateTime:"+zonedDateTime);
		System.out.println("ZonedDateTime:"+zonedDateTime1);
	}
}

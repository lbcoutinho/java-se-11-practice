package com.github.lbcoutinho.javase11practice._03textdatetimenumericobjs;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class Dates {

	public static void main(String[] args) {

		LocalDate ld = LocalDate.now();
		LocalDate ld2 = LocalDate.now().minusDays(62);
		System.out.println("ld = " + ld);
		LocalTime lt = LocalTime.now();
		LocalTime lt2 = LocalTime.now().minusHours(12);
		System.out.println("lt = " + lt);
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("ldt = " + ldt);
		Duration d = Duration.between(lt, lt2);
		System.out.println("duration = " + d);
		Period p = Period.between(ld, ld2);
		System.out.println("period = " + p);

		var z1 = ZoneId.of("America/Los_Angeles");
		System.out.println("z1 = " + z1);
		var z2 = ZoneId.of("GMT+2");
		System.out.println("z2 = " + z2);
		var z3 = ZoneId.of("UTC-05:00");
		System.out.println("z3 = " + z3);
		var z4 = ZoneId.systemDefault();
		System.out.println("z4 = " + z4);
		var londonZone = ZoneId.of("Europe/London");
		var laZone = ZoneId.of("America/Los_Angeles");
		LocalDateTime someTime = LocalDateTime.of(2019, 5, 1, 12,30,25);
		System.out.println("someTime = " + someTime);
		ZonedDateTime londonTime = ZonedDateTime.of(someTime, londonZone);
		System.out.println("londonTime = " + londonTime);
		ZonedDateTime laTime = londonTime.withZoneSameInstant(laZone);
		System.out.println("laTime = " + laTime);
	}
}

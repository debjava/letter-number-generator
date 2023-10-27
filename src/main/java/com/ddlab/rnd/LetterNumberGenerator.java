package com.ddlab.rnd;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class LetterNumberGenerator {

	public static long generateNo() {
		long time = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		System.out.println("Today Time in Number: " + time);
		return time;
	}

	public static long generateNo(int year, int month, int day, int hourIn24, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, (month - 1));
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.HOUR, hourIn24);
		cal.set(Calendar.MINUTE, minute);
		Date date = cal.getTime();
		long time = date.getTime();
		System.out.println("Custom Time in Number: " + time);
		return time;
	}

	public static void showFormatterDate(long time, String format) {
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String formattedDate = sdf.format(date);
		System.out.println("Formatted Date: " + formattedDate);
	}

	public static void main(String[] args) {
		String dateFormat = "dd-MMM-yyyy:hh:mm";
		long time = generateNo();
		showFormatterDate(time, dateFormat);
		time = generateNo(2021, 4, 19, 7, 31);
		showFormatterDate(time, dateFormat);
	}

}

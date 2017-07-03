package com.test.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MillDateConverter {
	
	public static String dFormat = "yyy-MM-dd HH:mm:ss";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dFormat);


	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		long milliSec=Long.parseLong("1086073200000");
		System.out.println(milliSec);
		calendar.setTimeInMillis(milliSec);
        System.out.println(simpleDateFormat.format(calendar.getTime()));
		
	}

}

package com.exe.springdi4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTimeService implements TimeService {

	public String getTimeString() {

		
		SimpleDateFormat sdf =
				(SimpleDateFormat)SimpleDateFormat.getDateTimeInstance(SimpleDateFormat.LONG,SimpleDateFormat.LONG);
		
		String now = sdf.format(new Date());		
		
		return now;
	}
}

package com.exe.springdi4;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

// 정확하게 MyTimeService 를 객체를 timeService 생성해서
// @AutoWired로 TimeService ts 찾아간다.  
@Component("timeService")
public class MyTimeService implements TimeService {
	public String getTimeString() {
		//날짜 찍기
		// Calendar : 시간 날짜를 유지관리
		// new Date : 현재시스템 날짜출력만
		
		// 내가원하는 날짜로 포멧 
		SimpleDateFormat sdf = (SimpleDateFormat)SimpleDateFormat
				.getDateTimeInstance(SimpleDateFormat.LONG,
						SimpleDateFormat.LONG);
		String now = sdf.format(new Date());
		return now;
	}
}

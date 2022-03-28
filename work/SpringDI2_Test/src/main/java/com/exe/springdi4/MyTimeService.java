package com.exe.springdi4;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("timeService")
public class MyTimeService implements TimeService {
	
	public String getTimeString() {
		
		//��¥ ���
		// Calendar : �ð� ��¥�� ��������
		// new Date : ����ý��� ��¥��¸�
		
		// �������ϴ� ��¥�� ���� 
		SimpleDateFormat sdf = (SimpleDateFormat)SimpleDateFormat
				.getDateTimeInstance(SimpleDateFormat.LONG,
						SimpleDateFormat.LONG);
		
		String now = sdf.format(new Date());
		
		return now;	
	}
}

package com.exe.springdi4;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

// ��Ȯ�ϰ� MyTimeService �� ��ü�� timeService �����ؼ�
// @AutoWired�� TimeService ts ã�ư���.  
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

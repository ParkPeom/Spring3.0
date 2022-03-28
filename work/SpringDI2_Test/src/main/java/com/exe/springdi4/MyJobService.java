package com.exe.springdi4;

import org.springframework.stereotype.Component;

@Component("myjobservice")
public class MyJobService implements JobService {

	public void getJob() {
		System.out.println("나는 프로그래머 입니다.");
	}
}

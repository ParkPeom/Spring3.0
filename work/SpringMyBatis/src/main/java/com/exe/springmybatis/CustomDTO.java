package com.exe.springmybatis;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// lombok.jar : getter , setter
// @Data <- 가장편한방법 
// @Getter
// @Setter
// @ToString : 오버라이딩해서 상속받을수있다.
// public @Data class CustomDTO {
public class CustomDTO {
	private @Getter @Setter int id;
	private @Getter @Setter String name;
	private @Setter @Getter int age; // 특정 Getter 만필요하면 @Getter만 적는다
		
	/*
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	*/
}

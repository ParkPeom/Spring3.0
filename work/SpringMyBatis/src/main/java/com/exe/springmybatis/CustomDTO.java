package com.exe.springmybatis;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// lombok.jar : getter , setter
// @Data <- �������ѹ�� 
// @Getter
// @Setter
// @ToString : �������̵��ؼ� ��ӹ������ִ�.
// public @Data class CustomDTO {
public class CustomDTO {
	private @Getter @Setter int id;
	private @Getter @Setter String name;
	private @Setter @Getter int age; // Ư�� Getter ���ʿ��ϸ� @Getter�� ���´�
		
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

package com.ittx.usermanager.model;

public class User {
	private int id; // ID
	private String name; // 姓名
	private int age; // 年龄
	private int sex; // 性别   0男  1女

	public User() {
	}

	public User(String name, int age, int sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public User(int id, String name, int age, int sex) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

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

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
}

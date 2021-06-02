package com.spring.colls;

import java.util.List;

public class Employee {
	private int id;
	private String name;
	private List<String> skills;

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

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	void show() {
		System.out.println(id + " " + name + " " + skills);
	}
}

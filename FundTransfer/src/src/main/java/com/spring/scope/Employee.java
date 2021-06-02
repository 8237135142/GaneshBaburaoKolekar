package com.spring.scope;

public class Employee {
	private int id;

	private String name;
	private String designation;

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesignation() {
		return designation;
	}

	public Employee(int id, String name, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;

	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	void show() {
		System.out.println(id + " " + name + " " + designation);
	}
}

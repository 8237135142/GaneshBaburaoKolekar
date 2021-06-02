package com.spring.lifecycleinit;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageGenarator {

	private String name;
	private Date date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MessageGenarator() {
		// TODO Auto-generated constructor stub
	}

	public String show() {
		return "Good morning: " + name + "---->" + date;
	}

	public void init() {
		// TODO Auto-generated method stub
		System.out.println("initialized the obj.............");
	}
	public void destroy() {
		System.out.println("Destory the obj.............");

	}

	
}

package com.spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/java/com/spring/scope/applicationContext.xml");

		System.out.println("================Singleton scope==================");
		Employee emp = (Employee) context.getBean("emp");
		emp.setId(101);
		emp.setName("khan");
		System.out.println(emp.getId()+"========"+emp.getName());
		
		Employee emp1 = (Employee) context.getBean("emp");
		System.out.println(emp1.getId()+"========"+emp1.getName());
		
		System.out.println(emp.hashCode() + "=====" + emp1.hashCode());
		
		
//		System.out.println("================prototype scope==================");
//		Employee emp2 = (Employee) context.getBean("emp");
//		emp2.setId(101);
//		emp2.setName("khan");
//		System.out.println(emp2.getId()+"========"+emp2.getName());
//		
//		Employee emp3 = (Employee) context.getBean("emp");
//		System.out.println(emp3.getId()+"========"+emp3.getName());
//		System.out.println("--------------");
//		
//
//		System.out.println(emp2.hashCode() + "=====" + emp3.hashCode());
		

	}
}

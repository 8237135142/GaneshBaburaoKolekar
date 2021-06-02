package com.hcl;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        Company company = context.getBean("company", Company.class);
        company.setCompanyId(414);
        company.setCompanyName("Hcl Technologies");
        System.out.println(company.toString());
        context.close();
    }
}

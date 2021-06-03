package com.hcl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context =  new ClassPathXmlApplicationContext("applicationcontext.xml");
        Company company = context.getBean("company", Company.class);

        Address address = context.getBean("address2",Address.class);
        Address address2 = context.getBean("address2",Address.class);
        
        company.setCompanyId(121);
        company.setCompanyName("Hcl");
        
        System.out.println(company);
        System.out.println(address);
        System.out.println(address2);
        System.out.println(company.getAddress());
        
    }
}

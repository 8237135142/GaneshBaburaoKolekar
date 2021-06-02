package com.hcl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        ConfigurableApplicationContext context =  new ClassPathXmlApplicationContext("applicationcontext.xml");
        Company company = context.getBean("company", Company.class);

//        Address address = context.getBean("address",Address.class);
//        Address address2 = context.getBean("address",Address.class);
        
        company.setCompanyId(414);
        company.setCompanyName("Hcl Technologies");
        
        System.out.println(company);
//        System.out.println(address);
//        System.out.println(address2);
        System.out.println(company.getAddress());
        Thread.sleep(1000);
        System.out.println(company.getAddress());
        context.close();
        
    }
}

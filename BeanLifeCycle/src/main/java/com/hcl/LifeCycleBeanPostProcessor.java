package com.hcl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class LifeCycleBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Post Process Before Initialization method is called : Bean Name " + beanName);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Post Process After Initialization method is called : Bean Name " + beanName);
		return bean;
	}

}

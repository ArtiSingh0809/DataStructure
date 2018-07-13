package com.pack;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class ClientClass {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring-context.xml"));
		Test test = (Test)beanFactory.getBean("test");
		Test test1 = (Test)beanFactory.getBean("test");
		test.hello();
		System.out.println(test == test1);
	}

}

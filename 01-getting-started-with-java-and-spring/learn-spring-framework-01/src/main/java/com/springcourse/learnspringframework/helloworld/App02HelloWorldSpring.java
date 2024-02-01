package com.springcourse.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {

		//Launch a Spring Context
		//var was introduced in java - 10
		//we generally use it retrieve objects of type <T>
		//here <T> is AnnotationConfigApplicationContext
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		//Configure the things we want spring to manage - @Configuration
		//We created a bean in our Configuration class using @Bean

		//Retrieving bean managed by spring here
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("AddressBean"));
		//We can also use bean type to retrieve bean
		System.out.println(context.getBean(Address.class));
		System.out.println(context.getBean("PersonBean2"));


	}

}

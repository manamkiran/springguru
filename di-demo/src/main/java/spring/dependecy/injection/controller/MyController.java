package spring.dependecy.injection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.dependecy.injection.service.GreetingService;

@Component
public class MyController {
	
	@Autowired
	public GreetingService greetingService;

	public String hello() {

		System.out.println("Hello");
		return greetingService.sayGreeting();
	}

}

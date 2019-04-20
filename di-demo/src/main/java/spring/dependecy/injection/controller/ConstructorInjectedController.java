package spring.dependecy.injection.controller;

import org.springframework.stereotype.Controller;

import spring.dependecy.injection.service.GreetingServicesImpl;

@Controller
public class ConstructorInjectedController {
	
	public GreetingServicesImpl greetingService;
	
	
	
	public ConstructorInjectedController(GreetingServicesImpl greetingService) {
		this.greetingService = greetingService;
	}



	String sayHello() {
		return greetingService.sayGreeting();
	}

}
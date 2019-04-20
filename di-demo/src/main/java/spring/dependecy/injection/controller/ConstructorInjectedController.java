package spring.dependecy.injection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import spring.dependecy.injection.service.GreetingService;

@Controller
public class ConstructorInjectedController {
	
	public GreetingService greetingService;
	
	
	@Autowired
	public ConstructorInjectedController(@Qualifier("constructorGreetingServicesImpl")GreetingService greetingService) {
		this.greetingService = greetingService;
	}



	public String sayHello() {
		return greetingService.sayGreeting();
	}

}
package spring.dependecy.injection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.dependecy.injection.service.GreetingServicesImpl;

@Controller
public class SetterInjectedController {

	public GreetingServicesImpl greetingService;

	String sayHello() {
		return greetingService.sayGreeting();
	}

	@Autowired
	public void setGreetingService(GreetingServicesImpl greetingService) {
		this.greetingService = greetingService;
	}

}

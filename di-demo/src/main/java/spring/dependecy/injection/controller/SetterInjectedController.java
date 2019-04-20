package spring.dependecy.injection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import spring.dependecy.injection.service.GreetingService;

@Controller
public class SetterInjectedController {

	public GreetingService greetingService;

	public String sayHello() {
		return greetingService.sayGreeting();
	}

	@Autowired
	public void setGreetingService(@Qualifier("setterGreetingServicesImpl") GreetingService greetingService) {
		this.greetingService = greetingService;
	}

}

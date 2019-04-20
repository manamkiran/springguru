package spring.dependecy.injection.controller;

import org.springframework.stereotype.Component;

@Component
public class MyController {

	public String hello() {

		System.out.println("Hello");
		return "Hello";
	}

}

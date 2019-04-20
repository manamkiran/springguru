package spring.dependecy.injection.service;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingServicesImpl implements GreetingService{

	@Override
	public String sayGreeting() {
		// TODO Auto-generated method stub
		return "Constructor Greeting Hello";
	}

}

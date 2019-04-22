package spring.dependecy.injection.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile({"en","default"})
public class PrimaryGreetingServicesImpl implements GreetingService{

	@Override
	public String sayGreeting() {
		// TODO Auto-generated method stub
		return "Primary Controller saying Hello";
	}

}

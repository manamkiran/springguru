package spring.dependecy.injection.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import spring.dependecy.injection.service.GreetingServicesImpl;

public class ConstructorInjectedControllerTest {

	private ConstructorInjectedController controller;

	@Before
	public void setup() {
		controller = new ConstructorInjectedController(new GreetingServicesImpl());
	}

	@Test
	public void testGreeting() throws Exception {
		assertEquals("Hello", controller.sayHello());
	}
}

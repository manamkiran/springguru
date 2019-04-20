package spring.dependecy.injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import spring.dependecy.injection.controller.ConstructorInjectedController;
import spring.dependecy.injection.controller.MyController;
import spring.dependecy.injection.controller.PropertyInjectedController;
import spring.dependecy.injection.controller.SetterInjectedController;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DiDemoApplication.class, args);
		MyController control = context.getBean("myController",MyController.class);
		control.hello();
		
		System.out.println(context.getBean(ConstructorInjectedController.class).sayHello());
		System.out.println(context.getBean(SetterInjectedController.class).sayHello());
		System.out.println(context.getBean(PropertyInjectedController.class).sayHello());
	}

}

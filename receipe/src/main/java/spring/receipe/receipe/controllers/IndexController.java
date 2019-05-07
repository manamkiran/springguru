package spring.receipe.receipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping({"","/","/index"})
	public String indexPage() {
		return "index";
	}
	
}

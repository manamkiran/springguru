package spring.pet.petclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import spring.pet.petclinic.services.VetService;

@Controller
public class VetsController {

	private final VetService vetService;

	@Autowired
	public VetsController(VetService vetService) {
		this.vetService = vetService;
	}

	@GetMapping({ "vets","vets.html" })
	public String listVets(Model model) {

		model.addAttribute("vets", vetService.findAll());
		
		return "vets/listVets";
	}

}

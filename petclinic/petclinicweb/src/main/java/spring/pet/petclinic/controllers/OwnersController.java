package spring.pet.petclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.pet.petclinic.services.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnersController {

	private final OwnerService ownerService;

	@Autowired
	public OwnersController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@GetMapping({ "/", "","/index" })
	public String listOwners(Model model) {

		model.addAttribute("owners", ownerService.findAll());
		return "owners/listOwners";
	}
	
	@GetMapping("/find")
	public String findOwner() {
		return "NotImplementedYet";
	}

}

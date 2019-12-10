package spring.receipe.receipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import spring.receipe.receipe.services.RecipeService;

@Slf4j
@Controller
public class IndexController {
	
	private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

	@GetMapping({"","/","/index"})
	public String indexPage(Model model) {
		log.debug("Getting Index page");

        model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}
	
}

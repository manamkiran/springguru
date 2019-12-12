package spring.receipe.receipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;
import spring.receipe.receipe.services.RecipeService;

@Slf4j
@Controller
public class RecipeController {

	private final RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping({ "/recipe/show/{recipeId}", })
	public String showRecipeById(@PathVariable String recipeId, Model model) {
		log.debug("Showing Recipe" + recipeId);

		model.addAttribute("recipe", recipeService.findById(Long.parseLong(recipeId)));
		return "recipe/show";
	}

}

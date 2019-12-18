package spring.receipe.receipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import spring.receipe.receipe.commands.RecipeCommand;
import spring.receipe.receipe.services.RecipeService;

@Slf4j
@Controller
public class RecipeController {

	private final RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping({ "/recipe/{recipeId}/show", })
	public String showRecipeById(@PathVariable String recipeId, Model model) {
		log.debug("Showing Recipe" + recipeId);

		model.addAttribute("recipe", recipeService.findById(Long.parseLong(recipeId)));
		return "recipe/show";
	}

	@GetMapping("/recipe/new")
	public String newRecipe(Model model) {
		log.debug("New Recipe");

		model.addAttribute("recipe", new RecipeCommand());
		return "recipe/recipeform";
	}

	@PostMapping("/recipe" )
	public String saveOrUpdateRecipe(@ModelAttribute RecipeCommand recipeCommand) {
		log.debug("Saving Recipe");
		RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(recipeCommand);
		return "redirect:/recipe/show/" + savedRecipeCommand.getId();
	}

}

package spring.receipe.receipe.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import spring.receipe.receipe.commands.RecipeCommand;
import spring.receipe.receipe.converters.RecipeCommandToRecipe;
import spring.receipe.receipe.converters.RecipeToRecipeCommand;
import spring.receipe.receipe.model.Recipe;
import spring.receipe.receipe.repositories.RecipeRepository;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;

	private final RecipeCommandToRecipe recipeCommandToRecipe;

	private final RecipeToRecipeCommand recipeToRecipeCommand;

	public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe,
			RecipeToRecipeCommand recipeToRecipeCommand) {
		this.recipeRepository = recipeRepository;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
	}

	@Override
	public Set<Recipe> getRecipes() {
		log.debug("I'm in the service");

		Set<Recipe> recipeSet = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		return recipeSet;
	}

	@Override
	public Recipe findById(long recipeId) {
		Optional<Recipe> recipe = recipeRepository.findById(recipeId);

		if (!recipe.isPresent()) {
			throw new RuntimeException("Recipe is Not Found for id : " + recipeId);
		}

		return recipe.get();
	}

	@Transactional
	@Override
	public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
		Recipe detachedRecipe = recipeCommandToRecipe.convert(recipeCommand);
		Recipe savedRecipe = recipeRepository.save(detachedRecipe);

		log.debug("Saved RecipeId : " + savedRecipe.getId());
		return recipeToRecipeCommand.convert(savedRecipe);
	}
}

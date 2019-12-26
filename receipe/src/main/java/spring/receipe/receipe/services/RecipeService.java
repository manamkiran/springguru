package spring.receipe.receipe.services;

import java.util.Set;

import spring.receipe.receipe.commands.RecipeCommand;
import spring.receipe.receipe.model.Recipe;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

	Recipe findById(long recipeId);
	
	RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

	RecipeCommand findCommandById(long recipeId);
	
	void deleteById(long recipeId);
}

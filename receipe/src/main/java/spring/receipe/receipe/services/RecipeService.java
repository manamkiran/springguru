package spring.receipe.receipe.services;

import java.util.Set;

import spring.receipe.receipe.model.Recipe;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
}

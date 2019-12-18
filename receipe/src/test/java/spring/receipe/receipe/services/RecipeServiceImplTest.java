package spring.receipe.receipe.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import spring.receipe.receipe.converters.RecipeCommandToRecipe;
import spring.receipe.receipe.converters.RecipeToRecipeCommand;
import spring.receipe.receipe.model.Recipe;
import spring.receipe.receipe.repositories.RecipeRepository;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;

	@Mock
	RecipeRepository recipeRepository;

	@Mock
	RecipeCommandToRecipe recipeCommandToRecipe;

	@Mock
	RecipeToRecipeCommand recipeToRecipeCommand;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
	}

	@Test
	public void testGetRecipes() throws Exception {

		Recipe recipe = new Recipe();
		Set<Recipe> recipeData = new HashSet<Recipe>();

		recipeData.add(recipe);
		// Mockito.when(recipeService.getRecipes()).thenReturn(recipeData); //weird that
		// it works
		Mockito.when(recipeRepository.findAll()).thenReturn(recipeData);

		Set<Recipe> recipes = recipeService.getRecipes();

		assertEquals(recipes.size(), 1);

		Mockito.verify(recipeRepository, times(1)).findAll();
	}

	@Test
	public void testFindById() throws Exception {

		Recipe testRecipe = new Recipe();

		Mockito.when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(testRecipe));

		Recipe recipe = recipeService.findById(anyLong());

		assertEquals(testRecipe, recipe);

		Mockito.verify(recipeRepository, times(1)).findById(anyLong());
		Mockito.verify(recipeRepository, never()).findAll();

	}
}
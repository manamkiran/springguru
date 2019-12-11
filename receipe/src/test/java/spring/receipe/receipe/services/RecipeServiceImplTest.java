package spring.receipe.receipe.services;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import spring.receipe.receipe.model.Recipe;
import spring.receipe.receipe.repositories.RecipeRepository;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		recipeService = new RecipeServiceImpl(recipeRepository);
	}

	@Test
	public void testGetRecipes() throws Exception {
		
		Recipe recipe = new Recipe();
		Set<Recipe> recipeData = new HashSet<Recipe>();
		
		recipeData.add(recipe);
		Mockito.when(recipeService.getRecipes()).thenReturn(recipeData);
		
		Set<Recipe> recipes = recipeService.getRecipes();
		
		assertEquals(recipes.size(), 1);
		
		Mockito.verify(recipeRepository,Mockito.times(1)).findAll();
	}
}
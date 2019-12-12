package spring.receipe.receipe.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import spring.receipe.receipe.model.Recipe;
import spring.receipe.receipe.services.RecipeService;

public class RecipeControllerTest {

	RecipeController recipeController;

	@Mock
	RecipeService recipeService;

	@Mock
	Model model;

	MockMvc mockMVC;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		recipeController = new RecipeController(recipeService);
		mockMVC = MockMvcBuilders.standaloneSetup(recipeController).build();
	}

	@Test
	public void testMockMVC() throws Exception {

		Recipe recipe = new Recipe();
		recipe.setDescription("Test");

		when(recipeService.findById(anyLong())).thenReturn(recipe);
		mockMVC.perform(get("/recipe/show/1"))
				.andExpect(status().isOk())
				.andExpect(view().name("recipe/show"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("recipe"));
	}

}

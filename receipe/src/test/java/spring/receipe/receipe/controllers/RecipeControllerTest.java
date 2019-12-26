package spring.receipe.receipe.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import spring.receipe.receipe.commands.RecipeCommand;
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
		mockMVC.perform(get("/recipe/1/show"))
				.andExpect(status().isOk())
				.andExpect(view().name("recipe/show"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("recipe"));
	}

	@Test
	public void testGetNewRecipeForm() throws Exception {
//        RecipeCommand command = new RecipeCommand();

		mockMVC.perform(get("/recipe/new"))
				.andExpect(status().isOk())
				.andExpect(view().name("recipe/recipeform"))
				.andExpect(model().attributeExists("recipe"));
	}

	@Test
	public void testPostNewRecipeForm() throws Exception {
		RecipeCommand command = new RecipeCommand();
		command.setId(2L);

		when(recipeService.saveRecipeCommand(any())).thenReturn(command);

		mockMVC.perform(post("/recipe")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("id", "")
				.param("description", "some string"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/recipe/2/show"));
	}

	@Test
	public void testGetUpdateView() throws Exception {
		RecipeCommand command = new RecipeCommand();
		command.setId(2L);

		when(recipeService.findCommandById(anyLong())).thenReturn(command);

		mockMVC.perform(get("/recipe/1/update"))
				.andExpect(status().isOk())
				.andExpect(view().name("recipe/recipeform"))
				.andExpect(model().attributeExists("recipe"));
	}

	@Test
	public void testDeleteAction() throws Exception {

		mockMVC.perform(get("/recipe/3/delete"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/"));

		verify(recipeService, times(1)).deleteById(anyLong());
	}

}

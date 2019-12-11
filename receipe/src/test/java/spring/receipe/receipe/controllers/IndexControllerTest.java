package spring.receipe.receipe.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import spring.receipe.receipe.model.Recipe;
import spring.receipe.receipe.services.RecipeService;

public class IndexControllerTest {

	IndexController indexController;
	
	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		indexController = new IndexController(recipeService);
	}

	@Test
	public void testMockMVC() throws Exception{
		MockMvc mockMVC = MockMvcBuilders.standaloneSetup(indexController).build();
		
		mockMVC.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
	}
	
	@Test
	public void testIndexPage() throws Exception {
		
		Set<Recipe> recipes = new HashSet<>();
		
		recipes.add(new Recipe());
		Recipe r =new Recipe();
		r.setDescription("Test");;
		recipes.add(r);
		
		when(recipeService.getRecipes()).thenReturn(recipes);
		
		ArgumentCaptor<Set<Recipe>> captor = ArgumentCaptor.forClass(Set.class);
		
		assertEquals("index", indexController.indexPage(model));
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"),captor.capture());
		assertEquals(2, captor.getValue().size());
	}

}
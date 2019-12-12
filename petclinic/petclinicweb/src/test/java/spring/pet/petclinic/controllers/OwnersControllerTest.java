package spring.pet.petclinic.controllers;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spring.pet.petclinic.model.Owner;
import spring.pet.petclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
public class OwnersControllerTest {
	@Mock
	private OwnerService ownerService;

	@InjectMocks
	private OwnersController ownersController;

	private Set<Owner> testOwnerSet;

	MockMvc mockMVC;

	@BeforeEach
	protected void setUp() throws Exception {
		testOwnerSet = new HashSet<Owner>();
		testOwnerSet.add(Owner.builder().id(1L).build());
		testOwnerSet.add(Owner.builder().id(2L).build());

		mockMVC = MockMvcBuilders
				.standaloneSetup(ownersController)
				.build();
	}

	@Test
	public void testListOwners() throws Exception {

		when(ownerService.findAll()).thenReturn(testOwnerSet);

		mockMVC.perform(get("/owners"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/listOwners"))
				.andExpect(model().attribute("owners", hasSize(2)));

	}

	@Test
	public void testListOwnersByIndex() throws Exception {

		when(ownerService.findAll()).thenReturn(testOwnerSet);

		mockMVC.perform(get("/owners/index"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/listOwners"))
				.andExpect(model().attribute("owners", hasSize(2)));

	}

	@Test
	public void testFindOwner() throws Exception {

		mockMVC.perform(get("/owners/find"))
				.andExpect(status().isOk())
				.andExpect(view().name("NotImplementedYet"));

	}

}

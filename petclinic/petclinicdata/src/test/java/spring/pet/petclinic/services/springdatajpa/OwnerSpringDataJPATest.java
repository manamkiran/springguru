package spring.pet.petclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import spring.pet.petclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
public class OwnerSpringDataJPATest {
	@Mock
	private OwnerRepository ownerRepository;
	
	@InjectMocks
	private OwnerSpringDataJPA ownerSpringDataJPA;

	@BeforeEach
	protected void setUp() throws Exception {
	}

	@Test
	public void testFindAll() throws Exception {
		ownerSpringDataJPA.findAll();
	}

	@Test
	public void testFindById() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testSave() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testDelete() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testDeleteById() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testFindByLastName() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}

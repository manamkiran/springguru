package spring.pet.petclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import spring.pet.petclinic.model.Owner;
import spring.pet.petclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
public class OwnerSpringDataJPATest {
	@Mock
	private OwnerRepository ownerRepository;

	@InjectMocks
	private OwnerSpringDataJPA ownerSpringDataJPA;

	private Long id = 1L;

	private String lastName = "last";

	private Owner testOwner = Owner.builder().id(id).lastName(lastName).build();

	private Set<Owner> testOwnerSet;

	@BeforeEach
	protected void setUp() throws Exception {
	}

	@Test
	public void testFindAll() throws Exception {
		Owner testOwner2 = Owner.builder().id(2L).build();
		testOwnerSet = new HashSet<Owner>();
		testOwnerSet.add(testOwner);
		testOwnerSet.add(testOwner2);

		when(ownerRepository.findAll()).thenReturn(testOwnerSet);
		Set<Owner> owners = ownerSpringDataJPA.findAll();

		assertNotNull(owners);
		assertEquals(2, owners.size());

		assertEquals(testOwnerSet, owners);
	}

	@Test
	public void testFindById() throws Exception {

		when(ownerRepository.findById(any())).thenReturn(Optional.of(testOwner));

		Owner owner = ownerSpringDataJPA.findById(id);

		assertNotNull(owner);
		assertEquals(id, owner.getId());

		assertEquals(testOwner, owner);

	}
	
	@Test
	public void testFindByIdNotFound() throws Exception {

		when(ownerRepository.findById(any())).thenReturn(Optional.empty());

		Owner owner = ownerSpringDataJPA.findById(id);

		assertNull(owner);
		verify(ownerRepository,times(1)).findById(any());
 
	}

	@Test
	public void testSave() throws Exception {
		
		when(ownerRepository.save(any())).thenReturn(testOwner);

		Owner owner = ownerSpringDataJPA.save(testOwner);
		
		assertNotNull(owner);
		assertEquals(testOwner, owner);
		
		verify(ownerRepository,times(1)).save(any());
	}

	@Test
	public void testDelete() throws Exception {
		ownerSpringDataJPA.delete(testOwner);

		verify(ownerRepository, times(1)).delete(any());
	}

	@Test
	public void testDeleteById() throws Exception {
		ownerSpringDataJPA.deleteById(id);

		verify(ownerRepository, times(1)).deleteById(any());
	}

	@Test
	public void testFindByLastName() throws Exception {
		when(ownerRepository.findByLastName(any())).thenReturn(testOwner);

		Owner owner = ownerSpringDataJPA.findByLastName(lastName);

		assertNotNull(owner);

		assertEquals(lastName, lastName);

		assertEquals(testOwner, owner);

	}

}

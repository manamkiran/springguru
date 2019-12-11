package spring.pet.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import spring.pet.petclinic.model.Owner;

public class OwnerServiceMapTest {

	private OwnerServiceMap ownerService;

	private Long id = 1L;

	private String lastName = "last";

	private Owner testOwner = Owner.builder().id(id).lastName(lastName).build();

	private Set<Owner> ownerSet;

	@BeforeEach
	protected void setUp() throws Exception {
		ownerService = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());

		ownerService.save(testOwner);

		ownerSet = new HashSet<Owner>();
		ownerSet.add(testOwner);
	}

	@Test
	public void testFindByLastName() throws Exception {

		Owner owner = ownerService.findByLastName(lastName);

		assertEquals(testOwner, owner);
		assertEquals(lastName, owner.getLastName());

	}

	@Test
	public void testFindByLastNameNotFound() throws Exception {

		Owner owner = ownerService.findByLastName("dummy");

		assertNull(owner);
	}

	@Test
	public void testSave() throws Exception {

		Long testID2 = 2L;

		Owner testOwner2 = Owner.builder().id(testID2).build();

		Owner savedOwner = ownerService.save(testOwner2);

		assertEquals(testID2, savedOwner.getId());

		assertEquals(testOwner2, savedOwner);

	}

	@Test
	public void testFindAll() throws Exception {
		Set<Owner> owners = ownerService.findAll();

		assertEquals(1, owners.size());

		assertEquals(ownerSet, owners);
	}

	@Test
	public void testFindById() throws Exception {
		Owner owner = ownerService.findById(id);
		assertEquals(testOwner, owner);
	}

	@Test
	public void testDeleteById() throws Exception {
		ownerService.deleteById(id);

		assertNull(ownerService.findById(id));
	}

	@Test
	public void testDelete() throws Exception {
		ownerService.delete(ownerService.findById(id));

		assertNull(ownerService.findById(id));
	}

}

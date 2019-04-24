package spring.pet.petclinic.services.map;

import spring.pet.petclinic.model.Pet;
import spring.pet.petclinic.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet,Long> implements PetService{

	@Override
	public Pet save(Pet object) {
		return map.put(object.getId(), object);
	}

}

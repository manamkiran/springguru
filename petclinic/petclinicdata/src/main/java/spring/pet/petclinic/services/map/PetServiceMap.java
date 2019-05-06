package spring.pet.petclinic.services.map;

import org.springframework.stereotype.Service;

import spring.pet.petclinic.model.Pet;
import spring.pet.petclinic.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet,Long> implements PetService{

	@Override
	public Pet save(Pet object) {
		return map.put(object.getId(), object);
	}

}

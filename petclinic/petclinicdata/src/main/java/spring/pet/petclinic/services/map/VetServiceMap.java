package spring.pet.petclinic.services.map;

import org.springframework.stereotype.Service;

import spring.pet.petclinic.model.Vet;
import spring.pet.petclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService{

	@Override
	public Vet findByLastName(Long lastName) {
		return null;
	}

}

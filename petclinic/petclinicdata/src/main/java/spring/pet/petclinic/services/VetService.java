package spring.pet.petclinic.services;

import spring.pet.petclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long> {

	Vet findByLastName(Long lastName);
	
}

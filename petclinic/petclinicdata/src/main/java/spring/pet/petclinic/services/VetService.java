package spring.pet.petclinic.services;

import java.util.Set;

import spring.pet.petclinic.model.Vet;

public interface VetService {
	
	Vet findById(Long id);
	
	Vet findByLastName(Long lastName);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();
	

}

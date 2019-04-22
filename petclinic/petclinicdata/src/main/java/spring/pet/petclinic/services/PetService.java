package spring.pet.petclinic.services;

import java.util.Set;

import spring.pet.petclinic.model.Pet;

public interface PetService {
	
	Pet findById(Long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();
	

}

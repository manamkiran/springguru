package spring.pet.petclinic.services;

import java.util.Set;

import spring.pet.petclinic.model.Owner;

public interface OwnerService {
	
	Owner findById(Long id);
	
	Owner findByLastName(Long lastName);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();
	

}

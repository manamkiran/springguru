package spring.pet.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import spring.pet.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{

}

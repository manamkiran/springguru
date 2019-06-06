package spring.pet.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import spring.pet.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long>{

}

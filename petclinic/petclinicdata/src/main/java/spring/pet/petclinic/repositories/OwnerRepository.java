package spring.pet.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import spring.pet.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{

}

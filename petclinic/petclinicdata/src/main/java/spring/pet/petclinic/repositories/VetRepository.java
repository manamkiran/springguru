package spring.pet.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import spring.pet.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long>{

	Vet findByLastName(String lastName);

}

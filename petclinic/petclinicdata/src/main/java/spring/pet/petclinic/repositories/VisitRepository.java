package spring.pet.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import spring.pet.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long>{

}

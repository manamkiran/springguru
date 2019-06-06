package spring.pet.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import spring.pet.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long>{

}

package spring.pet.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spring.pet.petclinic.model.PetType;
import spring.pet.petclinic.repositories.PetTypeRepository;
import spring.pet.petclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSpringDataJPA implements PetTypeService {

	private final PetTypeRepository petTypeRepository;

	@Autowired
	public PetTypeSpringDataJPA(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<PetType>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType petType) {
		return petTypeRepository.save(petType);
	}

	@Override
	public void delete(PetType petType) {
		petTypeRepository.delete(petType);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}

}

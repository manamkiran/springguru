package spring.pet.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spring.pet.petclinic.model.Pet;
import spring.pet.petclinic.repositories.PetRepository;
import spring.pet.petclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetTypeSpringDataJPA implements PetService {

	private final PetRepository petTypeRepository;

	@Autowired
	public PetTypeSpringDataJPA(PetRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> petTypes = new HashSet<Pet>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public Pet findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet petType) {
		return petTypeRepository.save(petType);
	}

	@Override
	public void delete(Pet petType) {
		petTypeRepository.delete(petType);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}

}

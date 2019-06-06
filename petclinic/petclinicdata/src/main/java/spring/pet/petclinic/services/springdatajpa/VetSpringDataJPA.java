package spring.pet.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spring.pet.petclinic.model.Vet;
import spring.pet.petclinic.repositories.VetRepository;
import spring.pet.petclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSpringDataJPA implements VetService {

	private final VetRepository vetRepository;

	@Autowired
	public VetSpringDataJPA(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<Vet>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet vet) {
		return vetRepository.save(vet);
	}

	@Override
	public void delete(Vet vet) {
		vetRepository.delete(vet);
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

	@Override
	public Vet findByLastName(String lastName) {
		return vetRepository.findByLastName(lastName);
	}

}

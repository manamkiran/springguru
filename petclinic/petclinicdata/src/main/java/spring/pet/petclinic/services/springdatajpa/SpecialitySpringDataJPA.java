package spring.pet.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spring.pet.petclinic.model.Speciality;
import spring.pet.petclinic.repositories.SpecialityRepository;
import spring.pet.petclinic.services.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialitySpringDataJPA implements SpecialityService {

	private final SpecialityRepository specialityRepository;

	@Autowired
	public SpecialitySpringDataJPA(SpecialityRepository SpecialityRepository) {
		this.specialityRepository = SpecialityRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> Specialitys = new HashSet<Speciality>();
		specialityRepository.findAll().forEach(Specialitys::add);
		return Specialitys;
	}

	@Override
	public Speciality findById(Long id) {
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality Speciality) {
		return specialityRepository.save(Speciality);
	}

	@Override
	public void delete(Speciality Speciality) {
		specialityRepository.delete(Speciality);
	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);
	}

}

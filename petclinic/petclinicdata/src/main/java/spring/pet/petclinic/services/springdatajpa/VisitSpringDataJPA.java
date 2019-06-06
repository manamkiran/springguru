package spring.pet.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spring.pet.petclinic.model.Visit;
import spring.pet.petclinic.repositories.VisitRepository;
import spring.pet.petclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSpringDataJPA implements VisitService {

	private final VisitRepository visitRepository;

	@Autowired
	public VisitSpringDataJPA(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<Visit>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit visit) {
		return visitRepository.save(visit);
	}

	@Override
	public void delete(Visit visit) {
		visitRepository.delete(visit);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}

}

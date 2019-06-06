package spring.pet.petclinic.services.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spring.pet.petclinic.model.Vet;
import spring.pet.petclinic.services.SpecialityService;
import spring.pet.petclinic.services.VetService;

@Service
@Profile({ "default", "map" })
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private SpecialityService specialityService;

	@Autowired
	public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}

	@Override
	public Vet findByLastName(String lastName) {
		return null;
	}

	@Override
	public Vet save(Vet vet) {
		if (vet != null && vet.getSpecialities() != null) {
			vet.getSpecialities().forEach(speciality -> {
					if (speciality.getId() == null) {
						specialityService.save(speciality);
				}
			});
		}
		return super.save(vet);
	}

}

package spring.pet.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spring.pet.petclinic.model.Visit;
import spring.pet.petclinic.services.VisitService;

@Service
@Profile({ "default", "map" })
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Visit save(Visit visit) {
		if (visit == null || visit.getPet() == null || visit.getPet().getId() == null
				|| visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Invalid Visit");
		}
		return super.save(visit);
	}

}

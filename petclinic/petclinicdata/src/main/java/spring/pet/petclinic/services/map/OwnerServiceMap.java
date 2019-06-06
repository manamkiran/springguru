package spring.pet.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spring.pet.petclinic.model.Owner;
import spring.pet.petclinic.services.OwnerService;
import spring.pet.petclinic.services.PetService;
import spring.pet.petclinic.services.PetTypeService;

@Service
@Profile({ "default", "map" })
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Owner save(Owner owner) {
		if (owner != null && owner.getPets() != null) {
			owner.getPets().forEach(pet -> {
				if (pet.getPetType() != null) {
					if (pet.getPetType().getId() == null) {
						pet.setPetType(petTypeService.save(pet.getPetType()));
					}
				} else {
					throw new RuntimeException("PetType is required");
				}
				if (pet.getId() == null) {
					petService.save(pet);
				}
			});
		}
		return super.save(owner);
	}

}

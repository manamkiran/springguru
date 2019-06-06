package spring.pet.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spring.pet.petclinic.model.PetType;
import spring.pet.petclinic.services.PetTypeService;

@Service
@Profile({ "default", "map" })
public class PetTypeMapService extends AbstractMapService<PetType,Long> implements PetTypeService{

}

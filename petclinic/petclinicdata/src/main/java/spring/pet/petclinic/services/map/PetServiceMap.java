package spring.pet.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spring.pet.petclinic.model.Pet;
import spring.pet.petclinic.services.PetService;

@Service
@Profile({ "default", "map" })
public class PetServiceMap extends AbstractMapService<Pet,Long> implements PetService{

}

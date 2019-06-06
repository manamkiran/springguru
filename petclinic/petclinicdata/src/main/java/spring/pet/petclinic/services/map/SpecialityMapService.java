package spring.pet.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spring.pet.petclinic.model.Speciality;
import spring.pet.petclinic.services.SpecialityService;

@Service
@Profile({ "default", "map" })
public class SpecialityMapService extends AbstractMapService<Speciality,Long> implements SpecialityService{

}

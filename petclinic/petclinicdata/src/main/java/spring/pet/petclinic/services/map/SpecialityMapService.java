package spring.pet.petclinic.services.map;

import org.springframework.stereotype.Service;

import spring.pet.petclinic.model.Speciality;
import spring.pet.petclinic.services.SpecialityService;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality,Long> implements SpecialityService{

}

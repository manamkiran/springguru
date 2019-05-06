package spring.pet.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import spring.pet.petclinic.model.Owner;
import spring.pet.petclinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService{

	@Override
	public Owner findByLastName(Long lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}

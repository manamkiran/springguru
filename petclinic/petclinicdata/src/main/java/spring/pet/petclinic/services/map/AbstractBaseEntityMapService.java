package spring.pet.petclinic.services.map;

import spring.pet.petclinic.model.BaseEntity;

public class AbstractBaseEntityMapService<T extends BaseEntity> extends AbstractMapService<BaseEntity, Long>{

	public BaseEntity save(BaseEntity object) {
		map.put(object.getId(), object);
		return object; 
	}


}

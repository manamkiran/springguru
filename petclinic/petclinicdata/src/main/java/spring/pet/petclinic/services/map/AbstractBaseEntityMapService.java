package spring.pet.petclinic.services.map;

import java.util.Collections;

import spring.pet.petclinic.model.BaseEntity;

public class AbstractBaseEntityMapService<T extends BaseEntity> extends AbstractMapService<BaseEntity, Long> {

	public BaseEntity save(BaseEntity baseEntity) {
		if (baseEntity.getId() == null) {
			baseEntity.setId(getNextId());
		}
		map.put(baseEntity.getId(), baseEntity);
		return baseEntity;
	}

	protected Long getNextId() {
		return Collections.max(map.keySet()) + 1;
	}

}

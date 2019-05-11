package spring.pet.petclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import spring.pet.petclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

	protected Map<Long, T> map = new HashMap<>();

	public Set<T> findAll() {
		return new HashSet<>(map.values());
	}

	public T findById(Long id) {
		return map.get(id);
	}

	public T save(T baseEntity) {
		if (baseEntity.getId() == null) {
			baseEntity.setId(getNextId());
		}
		map.put(baseEntity.getId(), baseEntity);
		return baseEntity;
	}

	protected Long getNextId() {
		try {
		return Collections.max(map.keySet()) + 1;
		}
		catch (NoSuchElementException e) {
			return 1L;
		}
	}

	public void deleteById(ID id) {
		map.remove(id);
	}

	public void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}

}

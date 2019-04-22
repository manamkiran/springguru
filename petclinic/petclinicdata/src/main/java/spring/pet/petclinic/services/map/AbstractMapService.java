package spring.pet.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import spring.pet.petclinic.services.CrudService;

public abstract class AbstractMapService<T, ID> implements CrudService<T, ID>{

	protected Map<ID, T> map = new HashMap<>();

	public Set<T> findAll() {
		return new HashSet<>(map.values());
	}

	public T findById(ID id) {
		return map.get(id);
	}

	public abstract T save(T object);

	public void deleteById(ID id) {
		map.remove(id);
	}

	public void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}

}

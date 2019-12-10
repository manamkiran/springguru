package spring.receipe.receipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import spring.receipe.receipe.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

    Optional<Category> findByDescription(String description);
}

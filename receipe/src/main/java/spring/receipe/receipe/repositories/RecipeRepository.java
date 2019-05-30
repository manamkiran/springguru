package spring.receipe.receipe.repositories;

import org.springframework.data.repository.CrudRepository;

import spring.receipe.receipe.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}

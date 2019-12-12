package spring.receipe.receipe.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import spring.receipe.receipe.model.Recipe;
import spring.receipe.receipe.repositories.RecipeRepository;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");

        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

	@Override
	public Recipe findById(long recipeId){
		Optional<Recipe> recipe = recipeRepository.findById(recipeId);
		
		if(!recipe.isPresent())
		{
			throw new RuntimeException("Recipe is Not Found for id : " + recipeId);
		}
		
		return recipe.get();
	}
}

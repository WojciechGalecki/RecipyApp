package wg.spring.recipes.repositories;

import org.springframework.data.repository.CrudRepository;
import wg.spring.recipes.domain.Recipe;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}

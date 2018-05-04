package wg.spring.recipes.repositories;

import org.springframework.data.repository.CrudRepository;
import wg.spring.recipes.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}

package wg.spring.recipes.repositories;

import org.springframework.data.repository.CrudRepository;
import wg.spring.recipes.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}

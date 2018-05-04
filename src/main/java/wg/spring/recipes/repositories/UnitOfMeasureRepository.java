package wg.spring.recipes.repositories;

import org.springframework.data.repository.CrudRepository;
import wg.spring.recipes.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}

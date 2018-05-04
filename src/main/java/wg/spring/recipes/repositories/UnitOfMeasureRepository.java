package wg.spring.recipes.repositories;

import org.springframework.data.repository.CrudRepository;
import wg.spring.recipes.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}

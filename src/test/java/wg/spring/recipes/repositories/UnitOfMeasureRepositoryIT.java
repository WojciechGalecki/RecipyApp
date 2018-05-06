package wg.spring.recipes.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import wg.spring.recipes.domain.UnitOfMeasure;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() throws Exception{

        Optional<UnitOfMeasure> optionalUnit = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", optionalUnit.get().getDescription());
    }

    @Test
    public void findByDescriptionWhoDoesNotExist() throws Exception{

        Optional<UnitOfMeasure> optionalUnit = unitOfMeasureRepository.findByDescription("No");

        assertTrue(!optionalUnit.isPresent());
    }
}
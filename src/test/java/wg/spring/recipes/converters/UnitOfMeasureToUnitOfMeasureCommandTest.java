package wg.spring.recipes.converters;

import org.junit.Before;
import org.junit.Test;
import wg.spring.recipes.commands.UnitOfMeasureCommand;
import wg.spring.recipes.domain.UnitOfMeasure;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    private static final Long ID_VALUE = 1L;
    private static final String DESCRIPTION = "description";

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void convert() throws Exception{

        //given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(ID_VALUE);
        unitOfMeasure.setDescription(DESCRIPTION);

        //when
        UnitOfMeasureCommand command = converter.convert(unitOfMeasure);

        //then
        assertNotNull(command);
        assertEquals(ID_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }
}
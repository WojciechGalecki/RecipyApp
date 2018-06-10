package wg.spring.recipes.converters;

import org.junit.Before;
import org.junit.Test;
import wg.spring.recipes.commands.UnitOfMeasureCommand;
import wg.spring.recipes.domain.UnitOfMeasure;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    private static final Long ID_VALUE = 1L;
    private static final String DESCRIPTION = "description";

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void convert() throws Exception{

        //given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(ID_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure unitOfMeasure = converter.convert(command);

        //then
        assertNotNull(unitOfMeasure);
        assertEquals(ID_VALUE, unitOfMeasure.getId());
        assertEquals(DESCRIPTION, unitOfMeasure.getDescription());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }
}
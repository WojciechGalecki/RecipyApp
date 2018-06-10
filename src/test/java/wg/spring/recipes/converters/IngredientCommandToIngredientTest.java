package wg.spring.recipes.converters;

import org.junit.Before;
import org.junit.Test;
import wg.spring.recipes.commands.IngredientCommand;
import wg.spring.recipes.commands.UnitOfMeasureCommand;
import wg.spring.recipes.domain.Ingredient;
import wg.spring.recipes.domain.Recipe;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientCommandToIngredientTest {

    private static final Long ID_VALUE = 1L;
    private static final String DESCRIPTION = "Hamburger";
    private static final BigDecimal AMOUNT = new BigDecimal("1");
    private static final Long UOM_ID = 2L;

    IngredientCommandToIngredient converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void convert() throws Exception {

        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setDescription(DESCRIPTION);
        command.setAmount(AMOUNT);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM_ID);
        command.setUom(unitOfMeasureCommand);

        //when
        Ingredient ingredient = converter.convert(command);

        //then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(UOM_ID, ingredient.getUom().getId());
    }

    @Test
    public void convertWithNullUom() throws Exception{

        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setDescription(DESCRIPTION);
        command.setAmount(AMOUNT);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();

        //when
        Ingredient ingredient = converter.convert(command);

        //then
        assertNotNull(ingredient);
        assertNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());
    }
}
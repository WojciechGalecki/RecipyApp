package wg.spring.recipes.converters;

import org.junit.Before;
import org.junit.Test;
import wg.spring.recipes.commands.IngredientCommand;
import wg.spring.recipes.domain.Ingredient;
import wg.spring.recipes.domain.Recipe;
import wg.spring.recipes.domain.UnitOfMeasure;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {

    private static final Long ID_VALUE = 1L;
    private static final String DESCRIPTION = "Hamburger";
    private static final BigDecimal AMOUNT = new BigDecimal("1");
    private static final Long UOM_ID = 2L;

    IngredientToIngredientCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void convert() throws Exception{

        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);
        ingredient.setUom(unitOfMeasure);

        //when
        IngredientCommand command = converter.convert(ingredient);

        //then
        assertEquals(ID_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
        assertEquals(AMOUNT, command.getAmount());
        assertEquals(UOM_ID, command.getUom().getId());
        assertNotNull(command.getUom());
        assertNotNull(command);
    }

    @Test
    public void convertWithNullUom() throws Exception {

        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);
        ingredient.setUom(null);

        //when
        IngredientCommand command = converter.convert(ingredient);

        //then
        assertEquals(ID_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
        assertEquals(AMOUNT, command.getAmount());
        assertNull(command.getUom());
        assertNotNull(command);
    }
}
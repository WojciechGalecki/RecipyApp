package wg.spring.recipes.converters;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import wg.spring.recipes.commands.CategoryCommand;
import wg.spring.recipes.commands.IngredientCommand;
import wg.spring.recipes.commands.NotesCommand;
import wg.spring.recipes.commands.RecipeCommand;
import wg.spring.recipes.domain.Difficulty;
import wg.spring.recipes.domain.Recipe;

import static org.junit.Assert.*;

public class RecipeCommandToRecipeTest {

    private static final Long RECIPE_ID = 1L;
    private static final Integer COOK_TIME = Integer.valueOf("1");
    private static final Integer PREP_TIME = Integer.valueOf("2");
    private static final String DESCRIPTION = "description";
    private static final String DIRECTIONS = "directions";
    private static final Difficulty DIFFICULTY = Difficulty.EASY;
    private static final Integer SERVINGS = Integer.valueOf("5");
    private static final String SOURCE = "source";
    private static final String URL = "url";
    private static final Long CAT_ID_1 = 1L;
    private static final Long CAT_ID_2 = 2L;
    private static final Long INGRED_ID_1 = 3L;
    private static final Long INGRED_ID_2 = 4L;
    private static final Long NOTES_ID = 5L;

    RecipeCommandToRecipe converter;

    @Before
    public void setUp() throws Exception {
        converter = new RecipeCommandToRecipe(new CategoryCommandToCategory(),
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new NotesCommandToNotes());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }


    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    public void convert() throws Exception {

        //given
        RecipeCommand command = new RecipeCommand();
        command.setId(RECIPE_ID);
        command.setCookTime(COOK_TIME);
        command.setPrepTime(PREP_TIME);
        command.setDescription(DESCRIPTION);
        command.setDirections(DIRECTIONS);
        command.setDifficulty(DIFFICULTY);
        command.setServings(SERVINGS);
        command.setSource(SOURCE);
        command.setUrl(URL);

        CategoryCommand categoryCommand1 = new CategoryCommand();
        categoryCommand1.setId(CAT_ID_1);
        CategoryCommand categoryCommand2 = new CategoryCommand();
        categoryCommand2.setId(CAT_ID_2);

        command.getCategories().add(categoryCommand1);
        command.getCategories().add(categoryCommand2);

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(NOTES_ID);

        command.setNotes(notesCommand);

        IngredientCommand ingredientCommand1 = new IngredientCommand();
        ingredientCommand1.setId(INGRED_ID_1);
        IngredientCommand ingredientCommand2 = new IngredientCommand();
        ingredientCommand2.setId(INGRED_ID_2);

        command.getIngredients().add(ingredientCommand1);
        command.getIngredients().add(ingredientCommand2);

        //when
        Recipe recipe = converter.convert(command);

        //then
        assertNotNull(recipe);
        assertEquals(RECIPE_ID, recipe.getId());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(NOTES_ID, recipe.getNotes().getId());
        assertEquals(2, recipe.getCategories().size());
        assertEquals(2, recipe.getIngredients().size());
    }
}
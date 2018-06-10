package wg.spring.recipes.converters;

import org.junit.Before;
import org.junit.Test;
import wg.spring.recipes.commands.NotesCommand;
import wg.spring.recipes.domain.Notes;

import static org.junit.Assert.*;

public class NotesCommandToNotesTest {

    private static final Long ID_VALUE = 1L;
    private static final String RECIPE_NOTES = "Notes";

    NotesCommandToNotes converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesCommandToNotes();
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void convert() throws Exception{

        //given
        NotesCommand command = new NotesCommand();
        command.setId(ID_VALUE);
        command.setRecipeNotes(RECIPE_NOTES);

        //when
        Notes notes = converter.convert(command);

        //then
        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
    }
}
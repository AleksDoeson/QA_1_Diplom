package Praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void sauceEnumExists() {
        assertNotNull(IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void fillingEnumExists() {
        assertNotNull(IngredientType.valueOf("FILLING"));
    }

    @Test
    public void invalidEnumThrowsException() {
        try {
            IngredientType.valueOf("INVALID");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("No enum constant"));
        }
    }

    @Test
    public void valuesLengthIsTwo() {
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length);
    }

    @Test
    public void firstEnumIsSauce() {
        assertEquals(IngredientType.SAUCE, IngredientType.values()[0]);
    }

    @Test
    public void secondEnumIsFilling() {
        assertEquals(IngredientType.FILLING, IngredientType.values()[1]);
    }

    @Test
    public void sauceNameIsCorrect() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void fillingNameIsCorrect() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}










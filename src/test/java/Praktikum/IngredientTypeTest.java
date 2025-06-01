package Praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeSauceExists() {
        // Проверка, что тип SAUCE существует в перечислении
        assertNotNull("SAUCE should exist", IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void testIngredientTypeFillingExists() {
        // Проверка, что тип FILLING существует в перечислении
        assertNotNull("FILLING should exist", IngredientType.valueOf("FILLING"));
    }

    @Test
    public void testIngredientTypeHandlesInvalidValue() {
        // Проверка на некорректное значение, которое не существует в перечислении
        try {
            IngredientType.valueOf("INVALID");
            fail("Expected IllegalArgumentException for invalid enum value");
        } catch (IllegalArgumentException e) {
            // Ожидаем исключение, так как INVALID не является допустимым значением для IngredientType
            assertTrue(e.getMessage().contains("No enum constant"));
        }
    }

    @Test
    public void testIngredientTypeValues() {
        // Проверка всех значений перечисления
        IngredientType[] values = IngredientType.values();
        assertNotNull("Values array should not be null", values);
        assertEquals("There should be 2 values in the enum", 2, values.length); // Ожидаем два значения: SAUCE и FILLING
        assertEquals("First value should be SAUCE", IngredientType.SAUCE, values[0]);
        assertEquals("Second value should be FILLING", IngredientType.FILLING, values[1]);
    }

    @Test
    public void testIngredientTypeCorrectEnumValues() {
        // Проверка правильности значений перечисления
        assertEquals("SAUCE name should be 'SAUCE'", IngredientType.SAUCE.name(), "SAUCE");
        assertEquals("FILLING name should be 'FILLING'", IngredientType.FILLING.name(), "FILLING");
    }
}









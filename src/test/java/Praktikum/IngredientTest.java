package Praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class IngredientTest {

    @Test
    public void getNameReturnsCorrectName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 50f);
        assertEquals("Ketchup", ingredient.getName());
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Bacon", 80f);
        assertEquals(80f, ingredient.getPrice(), 0.01f);
    }

    @Test
    public void getTypeReturnsCorrectType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Mustard", 30f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}







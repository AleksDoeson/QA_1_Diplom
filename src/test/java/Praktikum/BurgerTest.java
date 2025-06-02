package Praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private AutoCloseable mocks;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        mocks = MockitoAnnotations.openMocks(this);
        burger = new Burger();
        burger.setBuns(mockBun);
    }

    @After
    public void tearDown() throws Exception {
        mocks.close();
    }

    @Test
    public void addIngredientIncreasesSize() {
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientDecreasesSize() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientKeepsCorrectElement() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0);
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientSwapsElements_First() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientSwapsElements_Second() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceReturnsCorrectTotal() {
        when(mockBun.getPrice()).thenReturn(50.0f);
        when(mockIngredient1.getPrice()).thenReturn(20.0f);
        when(mockIngredient2.getPrice()).thenReturn(10.0f);

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        float expected = 50.0f * 2 + 20.0f + 10.0f;
        assertEquals(expected, burger.getPrice(), 0.01f);
    }

    @Test
    public void getReceiptReturnsFormattedReceipt() {
        when(mockBun.getName()).thenReturn("Sesame Bun");
        when(mockBun.getPrice()).thenReturn(50.0f);
        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient1.getPrice()).thenReturn(20.0f);
        when(mockIngredient2.getName()).thenReturn("Ketchup");
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient2.getPrice()).thenReturn(10.0f);

        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String expectedReceipt = "(==== Sesame Bun ====)\n" +
                "= filling Lettuce =\n" +
                "= sauce Ketchup =\n" +
                "(==== Sesame Bun ====)\n" +
                "\nPrice: 130.000000\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}










package Praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private AutoCloseable mocks; // Нужно для закрытия openMocks()

    @Mock
    private Bun mockBun; // Мокаем Bun

    @Mock
    private Ingredient mockIngredient1; // Мокаем Ingredient1

    @Mock
    private Ingredient mockIngredient2; // Мокаем Ingredient2

    @Before
    public void setUp() {
        mocks = MockitoAnnotations.openMocks(this); // Инициализируем моки
        burger = new Burger();
        burger.setBuns(mockBun);  // Устанавливаем булочку
    }

    @After
    public void tearDown() throws Exception {
        mocks.close(); // Закрываем моки после каждого теста
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Проверяем, что количество ингредиентов верное
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Удаляем первый ингредиент
        burger.removeIngredient(0);

        // Проверяем, что остался только один ингредиент
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient2, burger.ingredients.get(0));  // Ожидаем, что оставшийся ингредиент - это mockIngredient2
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Перемещаем ингредиент
        burger.moveIngredient(0, 1);

        // Проверяем, что ингредиенты перемещены корректно
        assertEquals(mockIngredient2, burger.ingredients.get(0));  // mockIngredient2 должен быть первым
        assertEquals(mockIngredient1, burger.ingredients.get(1));  // mockIngredient1 должен быть вторым
    }

    @Test
    public void testGetPrice() {
        // Настроим моки для возвращаемых значений
        when(mockBun.getPrice()).thenReturn(50.0f);
        when(mockIngredient1.getPrice()).thenReturn(20.0f);
        when(mockIngredient2.getPrice()).thenReturn(10.0f);

        // Добавляем ингредиенты и устанавливаем цену
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Проверяем, что цена бургера верная
        float expectedPrice = mockBun.getPrice() * 2 + mockIngredient1.getPrice() + mockIngredient2.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.01f);
    }

    @Test
    public void testGetReceipt() {
        // Настроим моки
        when(mockBun.getName()).thenReturn("Sesame Bun");
        when(mockBun.getPrice()).thenReturn(50.0f);
        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient1.getPrice()).thenReturn(20.0f);
        when(mockIngredient2.getName()).thenReturn("Ketchup");
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient2.getPrice()).thenReturn(10.0f);

        // Устанавливаем булочку и добавляем ингредиенты
        burger.setBuns(mockBun);
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









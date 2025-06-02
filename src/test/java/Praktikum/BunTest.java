package Praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        // Инициализируем объект перед каждым тестом
        bun = new Bun("Sesame Bun", 50.0f);
    }

    @Test
    public void getNameReturnsCorrectName() {
        // Проверяем, что getName возвращает корректное имя
        assertEquals("Sesame Bun", bun.getName());
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        // Проверяем, что getPrice возвращает корректную цену
        assertEquals(50.0f, bun.getPrice(), 0.01f);
    }
}









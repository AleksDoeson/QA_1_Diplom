package Praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testBunConstructor() {
        // Тестируем конструктор булочки
        Bun bun = new Bun("Sesame Bun", 50.0f);
        assertEquals("Название булки должно быть корректным", "Sesame Bun", bun.getName());
        assertEquals("Цена булки должна быть корректной", 50.0f, bun.getPrice(), 0.01f);  // Указание погрешности
    }

    @Test
    public void testGetName() {
        // Тестируем метод getName
        Bun bun = new Bun("Sesame Bun", 50.0f);
        assertEquals("Метод getName должен возвращать правильное название", "Sesame Bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        // Тестируем метод getPrice
        Bun bun = new Bun("Sesame Bun", 50.0f);
        assertEquals("Метод getPrice должен возвращать правильную цену", 50.0f, bun.getPrice(), 0.01f);  // Указание погрешности
    }
}








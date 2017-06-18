package assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMarketItems {
    MarketItem item1 = new PreparedMeal("Hot Dog", "My stand", -3.47);
    Produce item2 = new Produce("Berries", "My stand", -1.47, 2.39);
    Produce item3 = new Produce("Corn", "My stand",1.92, -2.97);

    @Test
    public void testNegativePrice() {
        assertEquals("Error for Hot Dog",item1.getPrice(), 0,0.001);
        assertEquals("Error for Berries",item2.getUnitPrice(), 0,0.001);
        assertEquals("Error for Corn",item3.getAmount(), 0,0.001);

    }

}

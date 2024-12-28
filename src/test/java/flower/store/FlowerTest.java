package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import labflowercontinue.flowers.Flower;
import labflowercontinue.flowers.FlowerColor;
import labflowercontinue.flowers.FlowerType;

import java.util.Random;

import org.junit.jupiter.api.Assertions;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Flower flower;

    @BeforeEach
    public void init() {
        flower = new Flower();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice());
    }


    @Test
    public void testFlowerType() {
        FlowerType type = FlowerType.Rose;
        flower.setFlowerType(type);
        Assertions.assertEquals(type, flower.getFlowerType());
    }

    @Test
    public void testEqualFlowers() {
        Flower flowerOne = new Flower();
        flowerOne.setColor(FlowerColor.RED);
        flowerOne.setFlowerType(FlowerType.Rose);

        Flower flowerTwo = new Flower();
        flowerTwo.setColor(FlowerColor.RED);
        flowerTwo.setFlowerType(FlowerType.Rose);

        Assertions.assertTrue(flowerOne.equal(flowerTwo));
    }

    @Test
    public void testNotEqualFlowers() {
        Flower flowerOne = new Flower();
        flowerOne.setColor(FlowerColor.RED);
        flowerOne.setFlowerType(FlowerType.Rose);

        Flower flowerTwo = new Flower();
        flowerTwo.setColor(FlowerColor.BLUE);
        flowerTwo.setFlowerType(FlowerType.Tulip);

        Assertions.assertFalse(flowerOne.equal(flowerTwo));
    }

    
}

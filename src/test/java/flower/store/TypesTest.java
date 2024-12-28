package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import labflowercontinue.flowers.Cactus;
import labflowercontinue.flowers.FlowerType;
import labflowercontinue.flowers.Romashka;
import labflowercontinue.flowers.Rose;
import labflowercontinue.flowers.Tulip;

import org.junit.jupiter.api.Assertions;

/**
 * Tests for flower types including Rose, Tulip, and Chamomile.
 */

public class TypesTest {

    private Rose rose;      
    private Tulip tulip;   
    private Romashka romashka; 
    private Cactus cactus;

    /**
     * Initializes the flower instances before each test.
     */
    @BeforeEach
    public void init() {
        rose = new Rose();
        tulip = new Tulip();
        romashka = new Romashka();
        cactus = new Cactus();
    }

    /**
     * Tests the default flower type of Rose.
     */
    @Test
    public void testRoseDefaultFlowerType() {
        Assertions.assertEquals(FlowerType.Rose, rose.getFlowerType());
    }

    // Similar test for Tulip
    @Test
    public void testTulipDefaultFlowerType() {
        Assertions.assertEquals(FlowerType.Tulip, tulip.getFlowerType());
    }

    // Similar test for Romashka
    @Test
    public void testChamomileDefaultFlowerType() {
        Assertions.assertEquals(FlowerType.Romashka, 
        romashka.getFlowerType());
    }

    // Similar test for Cactus
    @Test
    public void testCactusDefaultFlowerType() {
        Assertions.assertEquals(FlowerType.Cactus, 
        cactus.getFlowerType());
    }


}
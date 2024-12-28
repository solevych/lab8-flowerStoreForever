package flower.store;

import org.junit.jupiter.api.Test;
import labflowercontinue.Item;
import labflowercontinue.delivery.DHLDeliveryStrategy;
import labflowercontinue.delivery.Delivery;
import labflowercontinue.delivery.PostDeliveryStrategy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;

public class TestDelivery {

    // Constants to replace magic numbers
    private static final double LAPTOP_PRICE = 1000.0;
    private static final double SMARTPHONE_PRICE = 800.0;
    private static final double BOOK_PRICE = 20.0;
    private static final double NOTEBOOK_PRICE = 15.0;
    private static final double HIGH_SPEC_LAPTOP_PRICE = 1200.0;
    private static final double SMARTPHONE_G_PRICE = 900.0;

    static class TestItem extends Item {
        private final double price;

        TestItem(String description, double price) {
            setDescription(description);
            this.price = price;
        }

        @Override
        public double price() {
            return price;
        }
    }

    @Test
    void testDHLDeliveryStrategy() {
        Delivery dhlDelivery = new DHLDeliveryStrategy();
        List<Item> items = new ArrayList<>();
        items.add(new TestItem("Laptop", LAPTOP_PRICE));
        items.add(new TestItem("Smartphone", SMARTPHONE_PRICE));

        String result = dhlDelivery.deliver(items);

        Assertions.assertEquals(
            "The next items have been "
            + "sent to you via DHL: LaptopSmartphone", 
            result
        );
    }

    @Test
    void testPostDeliveryStrategy() {
        Delivery postDelivery = new PostDeliveryStrategy();
        List<Item> items = new ArrayList<>();
        items.add(new TestItem("Book", BOOK_PRICE));
        items.add(new TestItem("Notebook", NOTEBOOK_PRICE));

        String result = postDelivery.deliver(items);

        Assertions.assertEquals(
            "The next items have been sent " 
            + "to you via Post: BookNotebook", 
            result
        );
    }

    @Test
    void testEmptyItemListWithDHLDeliveryStrategy() {
        Delivery dhlDelivery = new DHLDeliveryStrategy();
        List<Item> items = new ArrayList<>();

        String result = dhlDelivery.deliver(items);

        Assertions.assertEquals(
            "The next items have been sent to you via DHL: ", 
            result
        );
    }

    @Test
    void testEmptyItemListWithPostDeliveryStrategy() {
        Delivery postDelivery = new PostDeliveryStrategy();
        List<Item> items = new ArrayList<>();

        String result = postDelivery.deliver(items);

        Assertions.assertEquals(
            "The next items have been sent to you via Post: ", 
            result
        );
    }

    @Test
    void testItemsWithSpecialCharactersInDescription() {
        Delivery dhlDelivery = new DHLDeliveryStrategy();
        List<Item> items = new ArrayList<>();
        items.add(new TestItem("Laptop with 16GB RAM", 
                                HIGH_SPEC_LAPTOP_PRICE));
        items.add(new TestItem("Smartphone (5G)", 
                                SMARTPHONE_G_PRICE));

        String result = dhlDelivery.deliver(items);

        Assertions.assertEquals(
            "The next items have been sent to you via DHL: " 
            + "Laptop with 16GB RAMSmartphone (5G)", 
            result
        );
    }

    @Test
    void testItemPricesAreNotUsedInDeliveryDescription() {
        Delivery postDelivery = new PostDeliveryStrategy();
        List<Item> items = new ArrayList<>();
        items.add(new TestItem("Book", BOOK_PRICE));
        items.add(new TestItem("Notebook", NOTEBOOK_PRICE));

        String result = postDelivery.deliver(items);

        Assertions.assertEquals(
            "The next items have been sent " 
            + "to you via Post: BookNotebook", 
            result
        );
    }

    // Main method to manually run tests
    public static void main(String[] args) {
        TestDelivery testDelivery = new TestDelivery();

        // Manually invoking test methods
        try {
            testDelivery.testDHLDeliveryStrategy();
            testDelivery.testPostDeliveryStrategy();
            testDelivery.testEmptyItemListWithDHLDeliveryStrategy();
            testDelivery.testEmptyItemListWithPostDeliveryStrategy();
            testDelivery.testItemsWithSpecialCharactersInDescription();
            testDelivery.testItemPricesAreNotUsedInDeliveryDescription();

            System.out.println("All tests ran successfully.");
        } catch (AssertionError e) {
            System.out.println("A test failed: " + e.getMessage());
        }
    }
}

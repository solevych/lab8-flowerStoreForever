package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import labflowercontinue.payment.PayPalPaymentStrategy;

import org.junit.jupiter.api.Assertions;

class TestPayment {

    private static final double INITIAL_PRICE = 100.0;
    private static final double PARTIAL_PAYMENT = 30.0;
    private static final double OVERPAYMENT = 150.0;
    private static final double UPDATED_PRICE_INCREASED = 120.0;
    private static final double UPDATED_PRICE_DECREASED = 80.0;
    private static final double NEGATIVE_PAYMENT = -50.0;

    private PayPalPaymentStrategy paymentStrategy;

    @BeforeEach
    void setUp() {
        paymentStrategy = new PayPalPaymentStrategy(INITIAL_PRICE);
    }

    @Test
    void testInitialIsFullyPayed() {
        Assertions.assertFalse(
                paymentStrategy.getIsFullyPayed(),
                "Payment should not be fully paid initially."
        );
        Assertions.assertEquals(
                INITIAL_PRICE, paymentStrategy.getPrice(),
                "Initial price should be set correctly."
        );
        Assertions.assertEquals(
                0.0, paymentStrategy.getPayed(),
                "Initial payed amount should be zero."
        );
    }

    @Test
    void testPartialPayment() {
        paymentStrategy.pay(PARTIAL_PAYMENT);
        Assertions.assertFalse(
                paymentStrategy.getIsFullyPayed(),
                "Payment should not be fully paid after a partial payment."
        );
        Assertions.assertEquals(
                PARTIAL_PAYMENT, paymentStrategy.getPayed(),
                "Payed amount should reflect the partial payment."
        );
    }

    @Test
    void testFullPayment() {
        paymentStrategy.pay(INITIAL_PRICE);
        Assertions.assertTrue(
                paymentStrategy.getIsFullyPayed(),
                "Payment should be fully paid after paying the exact amount."
        );
        Assertions.assertEquals(
                INITIAL_PRICE, paymentStrategy.getPayed(),
                "Payed amount should equal the price after full payment."
        );
    }

    @Test
    void testOverPayment() {
        paymentStrategy.pay(OVERPAYMENT);
        Assertions.assertTrue(
                paymentStrategy.getIsFullyPayed(),
                "Payment should be fully paid even after overpayment."
        );
        Assertions.assertEquals(
                OVERPAYMENT, paymentStrategy.getPayed(),
                "Payed amount should reflect the overpayment."
        );
    }

    @Test
    void testMultiplePayments() {
        paymentStrategy.pay(PARTIAL_PAYMENT);
        Assertions.assertFalse(
                paymentStrategy.getIsFullyPayed(),
                "Payment should not be fully paid after first partial payment."
        );
        Assertions.assertEquals(
                PARTIAL_PAYMENT, paymentStrategy.getPayed(),
                "Payed amount should reflect the first payment."
        );

        paymentStrategy.pay(INITIAL_PRICE - PARTIAL_PAYMENT);
        Assertions.assertTrue(
                paymentStrategy.getIsFullyPayed(),
                "Payment should be fully paid after second payment."
        );
        Assertions.assertEquals(
                INITIAL_PRICE, paymentStrategy.getPayed(),
                "Payed amount should equal the price after second payment."
        );
    }

    @Test
    void testSetPriceIncreasing() {
        paymentStrategy.pay(PARTIAL_PAYMENT);
        paymentStrategy.setPrice(UPDATED_PRICE_INCREASED);
        Assertions.assertFalse(
                paymentStrategy.getIsFullyPayed(),
                "Payment should not be fully paid after increasing the price."
        );
        Assertions.assertEquals(
                PARTIAL_PAYMENT, paymentStrategy.getPayed(),
                "Payed amount should remain unchanged after price increase."
        );
        Assertions.assertEquals(
                UPDATED_PRICE_INCREASED, paymentStrategy.getPrice(),
                "Price should be updated correctly."
        );
    }

    @Test
    void testSetPriceDecreasing() {
        paymentStrategy.pay(PARTIAL_PAYMENT);
        paymentStrategy.setPrice(UPDATED_PRICE_DECREASED);
        
        Assertions.assertEquals(
                PARTIAL_PAYMENT, paymentStrategy.getPayed(),
                "Payed amount should remain unchanged after price decrease."
        );
        Assertions.assertEquals(
                UPDATED_PRICE_DECREASED, paymentStrategy.getPrice(),
                "Price should be updated correctly."
        );
    }

    @Test
    void testZeroPayment() {
        paymentStrategy.pay(0.0);
        Assertions.assertFalse(
                paymentStrategy.getIsFullyPayed(),
                "Payment should not be fully paid after a zero payment."
        );
        Assertions.assertEquals(
                0.0, paymentStrategy.getPayed(),
                "Payed amount should remain zero after a zero payment."
        );
    }
}


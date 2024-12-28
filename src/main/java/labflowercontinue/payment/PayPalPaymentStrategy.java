package labflowercontinue.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
public class PayPalPaymentStrategy implements Payment {
    private double payed = 0;
    @Setter
    private double price;

    public PayPalPaymentStrategy(double price) {
        this.price = price;
    }

    @Override
    public boolean getIsFullyPayed() {
        return payed >= price;
    }

    @Override
    public void pay(double payedPrice) {
        System.out.println("Thank you for your PayPal payment!");
        payed += payedPrice;
    }
}


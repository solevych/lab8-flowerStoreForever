package labflowercontinue.store;

import lombok.Setter;
import labflowercontinue.Item;
import labflowercontinue.delivery.Delivery;
import labflowercontinue.payment.Payment;

import java.util.LinkedList;

public class Order {
    private LinkedList<Item> items;
    @Setter
    private Payment paymentStrategy;
    @Setter
    private Delivery deliveryStrategy;

    public double calculateTotalPrice() {
        double ans = 0;
        for (Item item : items) {
            ans += item.price();
        }
        return ans;
    }

    public boolean processOrder() {
        if (paymentStrategy.getIsFullyPayed()) {
            System.out.println("Starting delivery ...");
            deliveryStrategy.deliver(items);
            return true;
        } else {
            System.out.println("You have to pay for order before "
                    + "we can deliver it to you");
            return false;
        }
    }

    public void addItem(Item item) {
        items.add(item);
        paymentStrategy.setPrice(calculateTotalPrice());
    }

    public void removeItem(Item item) {
        items.remove(item);
        paymentStrategy.setPrice(calculateTotalPrice());
    }
}

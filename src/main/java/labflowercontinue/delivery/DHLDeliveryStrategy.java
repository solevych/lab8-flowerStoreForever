package labflowercontinue.delivery;

import java.util.List;

import labflowercontinue.Item;

public class DHLDeliveryStrategy implements Delivery {
    @Override
    public String deliver(List<Item> items) {
        
        StringBuilder result = new StringBuilder(
            "The next items have been sent to you via DHL: ");
        for (Item item : items) {
            result.append(item.getDescription());
        }
        return result.toString();
    }



}

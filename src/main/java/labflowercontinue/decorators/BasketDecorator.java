package labflowercontinue.decorators;

import labflowercontinue.Item;
import labflowercontinue.ItemDecorator;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = false)
@Getter
public class BasketDecorator extends ItemDecorator {
    private static final int BUSKET_PRICE = 4;
    private final Item item;

    public BasketDecorator(Item item) {
        this.item = item;
        setDescription("Basket for " + item.getDescription());
    }

    @Override
    public double price() {
        return BUSKET_PRICE + item.price();
    }
}

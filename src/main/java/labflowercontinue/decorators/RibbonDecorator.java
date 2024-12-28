package labflowercontinue.decorators;

import labflowercontinue.Item;
import labflowercontinue.ItemDecorator;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = false)
@Getter
public class RibbonDecorator extends ItemDecorator {
    private static final int RIBBON_PRICE = 40;
    private final Item item;

    public RibbonDecorator(Item item) {
        this.item = item;
        setDescription("Basket decoration for " + item.getDescription());
    }

    @Override
    public double price() {
        return RIBBON_PRICE + item.price();
    }
}
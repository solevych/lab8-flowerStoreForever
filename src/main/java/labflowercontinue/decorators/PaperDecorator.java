package labflowercontinue.decorators;

import labflowercontinue.Item;
import labflowercontinue.ItemDecorator;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = false)
@Getter
public class PaperDecorator extends ItemDecorator {
    private static final int PAPER_PRICE = 13;
    private final Item item;

    public PaperDecorator(Item item) {
        this.item = item;
        setDescription("Paper for " + item.getDescription());
    }

    @Override
    public double price() {
        return PAPER_PRICE + item.price();
    }
}

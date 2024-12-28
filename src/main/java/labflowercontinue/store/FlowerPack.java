package labflowercontinue.store;

import labflowercontinue.flowers.Flower;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FlowerPack {
    private Flower flower;
    private int quantity;

    public FlowerPack(Flower flower, int quantity) {
        this.flower = new Flower(flower);
        this.quantity = quantity;
     }
 
     public double getPrice() {
         return flower.getPrice() * quantity;
     }

    protected boolean search(Flower other) {
        return flower.equals(other);
    }
}

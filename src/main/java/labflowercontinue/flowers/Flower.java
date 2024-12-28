package labflowercontinue.flowers;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Flower {
    private double sepalLenght;
    private FlowerColor color;
    private double price;
    private FlowerType flowerType;

    

    public Flower(Flower flower) {
        this.color = flower.color;
        this.flowerType = flower.flowerType;
        this.price = flower.price;
        this.sepalLenght = flower.sepalLenght;
    }

    
    public boolean equal(Flower flower) {
        return (color.toString().equals(flower.color.toString()) 
        & flowerType == flower.getFlowerType());

    }
    

    public double price() {
        return price;
    }

}

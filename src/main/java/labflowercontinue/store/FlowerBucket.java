package labflowercontinue.store;

import java.util.List;

import labflowercontinue.flowers.Flower;

import java.util.ArrayList;


public class FlowerBucket {
    
    private List<FlowerPack> flowerPacks;

    public FlowerBucket() {
        this.flowerPacks = new ArrayList<>();

    }

    public void addFlowers(FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);

    }

    public double getPrice() {
        double price = 0;

        for (FlowerPack flowerPack : flowerPacks) {
            price += flowerPack.getPrice();
        }
        return price;
    }

    public List<FlowerPack> getFlowerPacks() {
        return new ArrayList<>(flowerPacks); 
    }

    public boolean searchFlower(Flower flower) {
        for (FlowerPack pack : flowerPacks) {
            if (pack.search(flower)) { return true; }
        }
        return false;
    }
}
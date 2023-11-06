package box;

import accessories.Accessory;
import accessories.chewtoys.ChewToy;
import accessories.chewtoys.SquealingChewToy;
import accessories.food.CannedFood;
import accessories.food.DryFood;
import accessories.food.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class MyDogBox {
    protected Random random = new Random();
    public List<Accessory> accessories = new ArrayList<>();
    private static int counter = 0;

    public MyDogBox() {
        addAccessories();
    }

    private void addAccessories(){
        for (int i = 0; i < 50; i++) {
            if (i < 20) {
                accessories.add(new ChewToy());
                accessories.add(new SquealingChewToy());
            }
            if (i < 40) {
                accessories.add(new CannedFood());
            }
            accessories.add(new DryFood());
        }
    }
    public void detectNonAttestationChew() {
        Consumer<Accessory> lambda = accessory -> {
            if (accessory instanceof ChewToy) {
                if (!((ChewToy) accessory).isCertificate()) {
                    System.out.println(accessory);
                    System.out.println("Brak atestu!!!");
                }
            }
        };
        accessories.forEach(lambda);
    }
    public void detectCaloricFood() {
        Consumer<Accessory> lambda = accessory -> {
            if (accessory instanceof Food) {
                if (((Food) accessory).getCalories() > 350 & counter < 32) {
                    System.out.println(accessory);
                    System.out.println("Uwaga na kalorie");
                    counter++;
                }
            }
        };
        accessories.forEach(lambda);
    }
    public void getSummarizedDryFoodCalories(){
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Consumer<Accessory> lambda = accessory -> {
            if (accessory instanceof DryFood) {
                atomicInteger.addAndGet(((DryFood) accessory).getCalories());
            }
        };
        accessories.forEach(lambda);
        System.out.println("Calories from dry food: " + atomicInteger.get());
    }
}

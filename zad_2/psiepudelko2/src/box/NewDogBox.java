package box;

import accessories.Accessory;
import accessories.chewtoys.SquealingChewToy;
import accessories.food.CannedFood;
import accessories.food.Food;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NewDogBox extends MyDogBox{
    public NewDogBox(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public void upgradeProducerName(String newName) {
        accessories.forEach(accessory -> {
            if (accessory.getProducer().length() <= 5) {
                accessory.setProducer(newName);
            }
        });
    }
    public void upgradeFrequency4All(){
        List<Integer> freq = Arrays.asList(16, 18, 20, 22, 24);
        int newFreq = freq.get(random.nextInt(freq.size()));
        accessories.forEach(accessory -> {
            if (accessory instanceof SquealingChewToy) {
                ((SquealingChewToy) accessory).setFrequency(newFreq);
            }
        });
    }
    public void getAverageWetFoodCalories() {
        AtomicInteger sum = new AtomicInteger(0);
        AtomicInteger count = new AtomicInteger(0);
        accessories.forEach(accessory -> {
                    if (accessory instanceof CannedFood) {
                        sum.addAndGet(((Food) accessory).getCalories());
                        count.incrementAndGet();
                    }
                });
        System.out.println("Average wet food calories: " + sum.get() / count.get());
    }
}

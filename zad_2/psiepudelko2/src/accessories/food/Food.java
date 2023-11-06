package accessories.food;

import accessories.Accessory;

public abstract class Food extends Accessory {
    protected int calories;

    public Food() {
    }

    public int getCalories() {
        return calories;
    }
}

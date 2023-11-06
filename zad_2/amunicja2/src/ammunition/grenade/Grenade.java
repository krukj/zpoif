package ammunition.grenade;

import ammunition.Ammunition;
import supplier.RandomSupplier;

import java.util.Random;

public abstract class Grenade extends Ammunition {
    protected static int counter = 0;
    protected boolean unarmed;

    public Grenade() {
        counter++;
        this.id = counter;
        this.unarmed = RandomSupplier.provideRandomSafeGenerator(new Random().nextBoolean());
    }

    public boolean isUnarmed() {
        return unarmed;
    }

    public void setUnarmed(boolean unarmed) {
        this.unarmed = unarmed;
    }
}

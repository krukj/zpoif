package chest;

import ammunition.Ammunition;
import ammunition.Shell;
import ammunition.grenade.AntiArmorGrenade;
import ammunition.grenade.Grenade;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class SecondChest extends AmmoChest{
    public SecondChest(List<Ammunition> chest) {
        this.chest = chest;
    }

    public void upgradeCaliber(double newCalibre) {
        chest.forEach((ammunition -> {
            if (ammunition instanceof Shell) {
                if (((Shell) ammunition).getCalibre() > 5.56) {
                    ((Shell) ammunition).setCalibre(newCalibre);
                }
            }
        }));
    }
    public void replaceLocked4All() {
        boolean random = new Random().nextBoolean();
        chest.forEach(ammunition -> {
            if (ammunition instanceof Grenade) {
                ((Grenade) ammunition).setUnarmed(random);
            }
        });
    }
    public void getSummarizedCO2Emission() {
        AtomicInteger sum = new AtomicInteger(0);
        chest.forEach(ammunition -> {
            if (ammunition instanceof AntiArmorGrenade) {
                sum.addAndGet(((AntiArmorGrenade) ammunition).getCO2Emission());
                System.out.println("sum of CO2: " + sum.get());
            }
        });
    }
    @FunctionalInterface
    interface MyAmmoGetter {
        Ammunition getGeneralAmmoByIndex(int index);
    }
    public MyAmmoGetter createMyAmmoGetter(){
        MyAmmoGetter ammoGetter = chest::get;
        return ammoGetter;
    }

}

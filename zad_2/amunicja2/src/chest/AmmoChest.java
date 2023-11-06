package chest;

import ammunition.Ammunition;
import ammunition.Shell;
import ammunition.grenade.AntiArmorGrenade;
import ammunition.grenade.DefensiveGrenade;
import ammunition.grenade.Grenade;
import ammunition.grenade.OffensiveGrenade;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public class AmmoChest {
    protected List<Ammunition> chest = new ArrayList<>();
    private static int counter = 0;

    public AmmoChest() {
        fillChest();
    }
    private void fillChest(){
        for (int i = 0; i < 25; i++) {
            if (i < 20) {
                chest.add(new AntiArmorGrenade());
                chest.add(new OffensiveGrenade());
                chest.add(new DefensiveGrenade());
            }
            chest.add(new Shell());
        }
    }
    public List<AntiArmorGrenade> getEcoArmourPiercingGrenades(){
        List<AntiArmorGrenade> result = new ArrayList<>();
        Consumer<Ammunition> lambda = ammunition -> {
            if (ammunition instanceof AntiArmorGrenade) {
                if (((AntiArmorGrenade) ammunition).getCO2Emission() <= 225) {
                    result.add((AntiArmorGrenade) ammunition);
                }
            }
        };
        chest.forEach(lambda);
        return result;
    }
    public void findUnlockedGrenades() {
        Consumer<Ammunition> lambda = ammunition -> {
            if (ammunition instanceof DefensiveGrenade | ammunition instanceof OffensiveGrenade) {
                if (!((Grenade) ammunition).isUnarmed()) {
                    System.out.println("Uwaga");
                    System.out.println(ammunition);
                }
            }
        };
        chest.forEach(lambda);
    }
    public void getSummarizedCaliber() {
        AtomicLong sum = new AtomicLong(0);
        Consumer<Ammunition> lambda = ammunition -> {
            if (ammunition instanceof Shell & counter <= 10) {
                sum.addAndGet((long) ((Shell) ammunition).getCalibre());
                counter++;
            }
            if (counter > 10) {
                System.out.println("sum of calibres sizes: " + sum.get());
            }
        };
        chest.forEach(lambda);
    }

    public List<Ammunition> getChest() {
        return chest;
    }
}

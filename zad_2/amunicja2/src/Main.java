import ammunition.Ammunition;
import ammunition.Shell;
import ammunition.grenade.AntiArmorGrenade;
import ammunition.grenade.Grenade;
import chest.AmmoChest;
import chest.SecondChest;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AmmoChest ammoChest = new AmmoChest();
        List<Ammunition> ammunitionList = ammoChest.getChest();
        System.out.println("----------------");
        for (Ammunition ammunition: ammunitionList) {
            System.out.println(ammunition);
        }
        System.out.println("----------------");
        List<AntiArmorGrenade> antiArmorGrenades = ammoChest.getEcoArmourPiercingGrenades();
        for (AntiArmorGrenade grenade: antiArmorGrenades) {
            System.out.println(grenade);
        }
        System.out.println("----------------");
        ammoChest.findUnlockedGrenades();
        System.out.println("----------------");
        ammoChest.getSummarizedCaliber();
        System.out.println("----------------");
        SecondChest secondChest = new SecondChest(ammunitionList);
        secondChest.upgradeCaliber(2);
        for (Ammunition ammunition: ammunitionList) {
            if (ammunition instanceof Shell) {
                System.out.println(ammunition);
            }
        }
        secondChest.replaceLocked4All();
        System.out.println("----------------");
        for (Ammunition ammunition: ammunitionList) {
            if (ammunition instanceof Grenade) {
                System.out.println(ammunition);
            }
        }
        System.out.println("----------------");
        secondChest.getSummarizedCO2Emission();



    }
}
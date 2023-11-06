package ammunition.grenade;

import supplier.RandomSupplier;

public class AntiArmorGrenade extends Grenade{
    private int CO2Emission;

    public AntiArmorGrenade() {
        this.CO2Emission = RandomSupplier.provideRandomCO2EmissionGenerator(220, 250);
    }

    public int getCO2Emission() {
        return CO2Emission;
    }

    @Override
    public String toString() {
        return "AntiArmorGrenade{" +
                "CO2Emission=" + CO2Emission +
                ", unarmed=" + unarmed +
                ", id=" + id +
                '}';
    }
}

package radios.CB;

import radios.Modulation;

public class HandCBRadio extends CBRadio{
    private boolean waterproof;

    public HandCBRadio(String producer, double frequency, Modulation modulation, int channel, boolean waterproof) {
        super(producer, frequency, modulation, channel);
        this.waterproof = waterproof;
    }

    @Override
    public String toString() {
        return "HandCBRadio{" +
                "waterproof=" + waterproof +
                ", channel=" + channel +
                ", producer='" + producer + '\'' +
                ", frequency=" + frequency +
                ", modulation=" + modulation +
                '}';
    }

}

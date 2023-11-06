package radios.CB;

import radios.Modulation;

public class CarCBRadio extends CBRadio{
    private boolean homologation;

    public CarCBRadio(String producer, double frequency, Modulation modulation, int channel, boolean homologation) {
        super(producer, frequency, modulation, channel);
        this.homologation = homologation;
    }

    @Override
    public String toString() {
        return "CarCBRadio{" +
                "homologation=" + homologation +
                ", channel=" + channel +
                ", producer='" + producer + '\'' +
                ", frequency=" + frequency +
                ", modulation=" + modulation +
                '}';
    }
}

package radios.CB;

import radios.Modulation;

public class StationaryCBRadio extends CBRadio{
    public StationaryCBRadio(String producer, double frequency, Modulation modulation, int channel) {
        super(producer, frequency, modulation, channel);
    }

    @Override
    public String toString() {
        return "StationaryCBRadio{" +
                "channel=" + channel +
                ", producer='" + producer + '\'' +
                ", frequency=" + frequency +
                ", modulation=" + modulation +
                '}';
    }
}

package radios;

public class ShortWaveRadio extends RadioStation{
    public ShortWaveRadio(String producer, double frequency, Modulation modulation) {
        super(producer, frequency, modulation);
    }
    public void setFrequencyAndFM(double frequency) {
        this.frequency = frequency;
        this.modulation = Modulation.FM;
    }

    @Override
    public String toString() {
        return "ShortWaveRadio{" +
                "producer='" + producer + '\'' +
                ", frequency=" + frequency +
                ", modulation=" + modulation +
                '}';
    }
}

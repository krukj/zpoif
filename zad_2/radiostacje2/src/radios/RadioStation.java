package radios;

public abstract class RadioStation {
    protected String producer;
    protected double frequency;
    protected Modulation modulation;

    public RadioStation(String producer, double frequency, Modulation modulation) {
        this.producer = producer;
        this.frequency = frequency;
        this.modulation = modulation;
    }

    public String getProducer() {
        return producer;
    }
}

package media.electronic;

public class Radio extends ElectronicMassMedia{
    public Radio(String name, int reputation, int audience, int truthfulness) {
        super(name, reputation, audience, truthfulness);
    }

    @Override
    public String toString() {
        return "Radio{" +
                "audience=" + audience +
                ", truthfulness=" + truthfulness +
                ", name='" + name + '\'' +
                ", reputation=" + reputation +
                '}';
    }
}

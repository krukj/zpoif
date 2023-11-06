package media.electronic;

public class TV extends ElectronicMassMedia{
    private boolean newsChannel;

    public TV(String name, int reputation, int audience, int truthfulness, boolean newsChannel) {
        super(name, reputation, audience, truthfulness);
        this.newsChannel = newsChannel;
    }

    @Override
    public String toString() {
        return "TV{" +
                "newsChannel=" + newsChannel +
                ", audience=" + audience +
                ", truthfulness=" + truthfulness +
                ", name='" + name + '\'' +
                ", reputation=" + reputation +
                '}';
    }
}

package media.electronic;

import media.MassMedia;

public abstract class ElectronicMassMedia extends MassMedia {
    protected int audience;
    protected int truthfulness;

    public ElectronicMassMedia(String name, int reputation, int audience, int truthfulness) {
        super(name, reputation);
        this.audience = audience;
        this.truthfulness = truthfulness;
    }
}

package media;

public abstract class MassMedia {
    protected String name;
    protected int reputation;

    public MassMedia(String name, int reputation) {
        this.name = name;
        this.reputation = reputation;
    }
}

package media;

public class Newspaper extends MassMedia{
    private int circulation;
    private int pagesNumber;

    public Newspaper(String name, int reputation, int circulation, int pagesNumber) {
        super(name, reputation);
        this.circulation = circulation;
        this.pagesNumber = pagesNumber;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "circulation=" + circulation +
                ", pagesNumber=" + pagesNumber +
                ", name='" + name + '\'' +
                ", reputation=" + reputation +
                '}';
    }
}

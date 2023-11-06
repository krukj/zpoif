package ammunition;

import supplier.RandomSupplier;

public class Shell extends Ammunition{
    private double calibre;
    private static int counter = 0;

    public Shell() {
        counter++;
        this.id = counter;
        this.calibre = RandomSupplier.provideRandomCaliberGenerator();
    }

    public double getCalibre() {
        return calibre;
    }

    public void setCalibre(double calibre) {
        this.calibre = calibre;
    }

    @Override
    public String toString() {
        return "Shell{" +
                "calibre=" + calibre +
                ", id=" + id +
                '}';
    }
}

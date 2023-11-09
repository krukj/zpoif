package pacjenci.ubezpieczeni;

public class PacjentWspolpracujacy extends Ubezpieczony{
    public PacjentWspolpracujacy() {
    }

    @Override
    public String toString() {
        return "PacjentWspolpracujacy{" +
                "id=" + id +
                ", wiek=" + wiek +
                ", problemy=" + problemy +
                '}';
    }
}

package pacjenci.ubezpieczeni;

public class PacjentNiepelnoletni extends Ubezpieczony{
    public PacjentNiepelnoletni() {
    }

    @Override
    public String toString() {
        return "PacjentNiepelnoletni{" +
                "id=" + id +
                ", wiek=" + wiek +
                ", problemy=" + problemy +
                '}';
    }
}

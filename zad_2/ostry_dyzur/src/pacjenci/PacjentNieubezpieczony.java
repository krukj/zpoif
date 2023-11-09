package pacjenci;

public class PacjentNieubezpieczony extends Pacjent{
    public PacjentNieubezpieczony() {
    }

    @Override
    public String toString() {
        return "PacjentNieubezpieczony{" +
                "wiek=" + wiek +
                ", problemy=" + problemy +
                '}';
    }
}

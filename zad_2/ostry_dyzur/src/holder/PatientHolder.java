package holder;

import pacjenci.Pacjent;
import pacjenci.PacjentNieubezpieczony;
import pacjenci.Problem;
import pacjenci.ubezpieczeni.PacjentRozczeniowy;
import pacjenci.ubezpieczeni.PacjentNiepelnoletni;
import pacjenci.ubezpieczeni.PacjentWspolpracujacy;
import pacjenci.ubezpieczeni.StopienRozczeniowosci;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class PatientHolder {
    private List<Pacjent> pacjenci = new ArrayList<>();
    private static int counter = 0;
    private static int kleszczCounter = 0;
    private static Random random = new Random();

    public PatientHolder() {
        dodajPacjentow();
    }
    private void dodajPacjentow(){
        for (int i = 0; i < 10; i++) {
            pacjenci.add(new PacjentNieubezpieczony());
            pacjenci.add(new PacjentNiepelnoletni());
            pacjenci.add(new PacjentRozczeniowy());
            pacjenci.add(new PacjentWspolpracujacy());
        }
    }

    public List<Pacjent> getPatients() {
        return pacjenci;
    }
    public static void isCovidPositive(Pacjent pacjent) {
        if (random.nextDouble() < 0.1) {
            System.out.println("Tak");
        } else {
            System.out.println("Nie");
        }
    }
    public void generalDiagnose(Pacjent pacjent) {
        if (counter > 10) {
            System.out.println("Brak limitu punktów");
        } else {
            if (random.nextBoolean()) {
                System.out.println("Chory");
            } else {
                System.out.println("Zdrowy");
            }
        }
    }
    public int extractDemandingPatients(){
        AtomicInteger integer = new AtomicInteger(0);
        Consumer<Pacjent> consumer = pacjent -> {
            if (pacjent instanceof PacjentRozczeniowy) {
                if (((PacjentRozczeniowy) pacjent).getStopienRozczeniowosci() == StopienRozczeniowosci.AVERAGE | ((PacjentRozczeniowy) pacjent).getStopienRozczeniowosci() == StopienRozczeniowosci.SMALL) {
                    integer.incrementAndGet();
                }
            }
        };
        pacjenci.forEach(consumer);
        return integer.get();
    }
    public void detectNotInsuredPatients() {
        pacjenci.forEach(pacjent -> {
            if (pacjent instanceof PacjentNieubezpieczony) {
                System.out.println("Brak ubezpieczenia!");
            }
        });
    }
    public void detectTickBiten() {
        pacjenci.forEach(pacjent -> {
            if (pacjent.getProblemy().contains(Problem.POGRYZIENIE_PRZEZ_KLESZCZA)) {
                kleszczCounter++;
                if (kleszczCounter % 3 == 0) {
                    System.out.println("To juz kolejna trojka pacjentow pogryzionych przez kleszcze w tym tygodniu");
                }
            }

        });
    }
}

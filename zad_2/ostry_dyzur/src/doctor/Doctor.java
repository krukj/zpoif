package doctor;

import holder.PatientHolder;
import pacjenci.Pacjent;
import pacjenci.Problem;
import pacjenci.ubezpieczeni.Ubezpieczony;

import java.util.Random;

public class Doctor {
    private final Random random = new Random();
    private final PatientHolder patientHolder;

    public Doctor(PatientHolder patientHolder) {
        this.patientHolder = patientHolder;
    }

    public void diagnoseAll() {
        for (Pacjent pacjent: patientHolder.getPatients()) {
            for (Problem problem: pacjent.getProblemy()) {
                pacjent.applyDiagnose(pacjent1 -> {
                    if (problem == Problem.POGRYZIENIE_PRZEZ_KLESZCZA) {
                        if (pacjent.getWiek() < 40) {
                            if (random.nextDouble() < 0.7) {
                                System.out.println("Borelioza!");
                            }
                        } else if (random.nextDouble() < 0.3) {
                            System.out.println("Borelioza!");
                        } else {
                            System.out.println("Pacjent zdrowy!");
                        }
                    }
                    if (problem == Problem.GORACZKA) {
                        PatientHolder.isCovidPositive(pacjent);
                    }
                    if (problem == Problem.SPIACZKA) {
                        patientHolder.generalDiagnose(pacjent);
                    }
                    if (problem == Problem.RANA_KLUTA) {
                        if (pacjent.getWiek() > 60) {
                            System.out.println("To nie wgląda dobrze");
                        } else {
                            if (pacjent instanceof Ubezpieczony) {
                                System.out.println("Pacjent o nr ubezpieczenia: " + ((Ubezpieczony) pacjent).getId() + " będzie żył");
                            } else {
                                System.out.println("Pacjent nie ubezpieczony ale też będzie żył.");
                            }
                        }
                    }
                });
            }
        }
    }
}

import doctor.Doctor;
import holder.PatientHolder;
import pacjenci.Pacjent;

import java.util.List;

public class Demonstrator {
    public static void main(String[] args) {
        PatientHolder holder = new PatientHolder();
        Doctor doctor = new Doctor(holder);
        System.out.println("---------");
        List<Pacjent> pacjenci = holder.getPatients();
        for (Pacjent pacjent: pacjenci) {
            System.out.println(pacjent);
        }
        System.out.println("---------");
        System.out.println(holder.extractDemandingPatients());

        System.out.println("---------");
        doctor.diagnoseAll();

        System.out.println("---------");
        holder.detectNotInsuredPatients();

        System.out.println("---------");
        holder.detectTickBiten();

    }
}
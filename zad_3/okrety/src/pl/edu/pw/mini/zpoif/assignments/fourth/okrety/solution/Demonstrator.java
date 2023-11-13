package pl.edu.pw.mini.zpoif.assignments.fourth.okrety.solution;

import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.Okret;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.OkretDesantowy;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.OkretPodwodny;

import java.util.List;
import java.util.Map;

public class Demonstrator {
    public static void main(String[] args) {
        Implementacja imp = new Implementacja();
        List<Okret> okrety = imp.okrety;

        System.out.println("----------------------");
        System.out.println("metoda zwracająca najszybszy okręt");
        System.out.println(imp.metoda1());

        System.out.println("----------------------");
        System.out.println("metoda zwracająca sumę wyporności okrętów, których nazwa kończy się na \"o\"");
        System.out.println(imp.metoda2());

        System.out.println("----------------------");
        System.out.println("metoda zwracająca listę okrętów o wyporności nie mniejszej niż 370 ton i długości nie\n" +
                "większej niż 50m.");
        List<Okret> okrety3 = imp.metoda3();
        okrety3.forEach(System.out::println);

        System.out.println("----------------------");
        System.out.println("metoda zwracająca okręt będący korwetą o najmniejszej wyporności");
        System.out.println(imp.metoda4());

        System.out.println("----------------------");
        System.out.println("metoda dodająca suffix \"_the best\" do nazwy dla każdego niszczyciela min lub trałowca\n" +
                "o mocy napędu większej niż 2000 i zasięgu większym niż 2000. Ewentualne duplikaty\n" +
                "mają być usuwane");
        imp.metoda5();
        for (Okret okret: okrety) {
            System.out.println(okret.getNazwa());
        }

        System.out.println("----------------------");
        System.out.println("metoda zwracająca posortowane okręty desantowe (po nazwie) w porządku rosnącym,\n" +
                "począwszy od 7-mego na liście (przed sortowaniem) i 3-go (po posortowaniu).");
        List<OkretDesantowy> okrety6 = imp.metoda6();
        okrety6.forEach(System.out::println);

        System.out.println("----------------------");
        System.out.println("metda zwracająca zbiór Stringów, z których każdy reprezentuje trałowiec o wyporności\n" +
                "większej niż 210 ton w następujący sposób: [nazwa trałowca (wszystkie litery duże)– wyporność] np. [ORP FLAMING – 470]. Zbiór jest ograniczony do 4 elementów.");
        List<String> stringList = imp.metoda7();
        stringList.forEach(System.out::println);

        System.out.println("----------------------");
        System.out.println("metoda zwracająca mapę okrętów podwodnych gdzie kluczem jest nazwa a wartością obiekt okrętu. W przypadku wykrycia duplikatu do mapy wstawiany jest okręt mający więcej torped.");
        Map<String, OkretPodwodny> okretyMap = imp.metoda8();
        for (Map.Entry<String, OkretPodwodny> entry: okretyMap.entrySet()) {
            System.out.println(entry.getKey() + " --- " + entry.getValue());
        }

        System.out.println("----------------------");
        System.out.println("metoda sortująca (malejąco) 20 okrętów po wyporności (począwszy od 10-go na liście bazowej) z wyjątkiem okrętów hydrograficznych. Pięć pierwszych po posortowaniu (począwszy od drugiego) jest wypisywanych na konsolę.");
        imp.metoda9();




    }
}

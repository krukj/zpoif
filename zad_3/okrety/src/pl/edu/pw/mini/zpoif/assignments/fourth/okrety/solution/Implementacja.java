package pl.edu.pw.mini.zpoif.assignments.fourth.okrety.solution;

import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.*;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.generator.GeneratorOkretow;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.przeciwminowe.NiszczycielMin;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.przeciwminowe.Tralowiec;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Implementacja implements Okrety{
    List<Okret> okrety;

    public Implementacja() {
        this.okrety = GeneratorOkretow.generujOkrety();
    }

    @Override
    public Okret metoda1() {
        return okrety.stream()
                .max(Comparator.comparing(Okret::getPredkosc))
                .get();
    }

    @Override
    public Integer metoda2() {
        return okrety.stream()
                .filter(okret -> okret.getNazwa().endsWith("o"))
                .mapToInt(Okret::getWypornosc)
                .sum();
    }

    @Override
    public List<Okret> metoda3() {
        return okrety.stream()
                .filter(okret -> okret.getWypornosc() >= 370 & okret.getDlugosc() <= 50)
                .collect(Collectors.toList());
    }

    @Override
    public Korweta metoda4() {
        return okrety.stream()
                .filter(okret -> okret instanceof Korweta)
                .min(Comparator.comparing(Okret::getWypornosc))
                .map(Korweta.class::cast)
                .get();

    }

    @Override
    public void metoda5() {
        okrety.stream()
                .filter(okret -> okret instanceof NiszczycielMin | okret instanceof Tralowiec)
                .filter(okret -> okret.getMocNapedu() > 2000 & okret.getZasieg() > 2000)
                .distinct()
                .forEach(okret -> okret.setNazwa((okret.getNazwa() + "_the best")));
    }

    @Override
    public List<OkretDesantowy> metoda6() {
        return okrety.stream()
                .skip(6)
                .filter(okret -> okret instanceof OkretDesantowy)
                .map(OkretDesantowy.class::cast)
                .sorted(Comparator.comparing(OkretDesantowy::getNazwa))
                .skip(3)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> metoda7() {
        return okrety.stream()
                .filter(okret -> okret instanceof Tralowiec)
                .skip(1)
                .filter(okret -> okret.getWypornosc() > 210)
                .map(okret -> "[" + okret.getNazwa().toUpperCase() + "-" + okret.getWypornosc() + "]")
                .limit(4)
                .collect(Collectors.toList());

    }

    @Override
    public Map<String, OkretPodwodny> metoda8() {
        return okrety.stream()
                .filter(okret -> okret instanceof OkretPodwodny)
                .map(OkretPodwodny.class::cast)
                .collect(Collectors.toMap(
                        OkretPodwodny::getNazwa,
                        okretPodwodny -> okretPodwodny,
                        (okret1, okret2) -> {
                            if (okret1.getLiczbaTorped() > okret2.getLiczbaTorped()) {
                                return okret1;
                            } else {return okret2;}
                        }
                ));

    }

    @Override
    public void metoda9() {
        okrety.stream()
                .filter(okret -> ! (okret instanceof OkretHydrograficzny))
                .skip(10)
                .sorted(Comparator.comparing(Okret::getWypornosc).reversed())
                .skip(1)
                .limit(5)
                .forEach(System.out::println);
    }
}

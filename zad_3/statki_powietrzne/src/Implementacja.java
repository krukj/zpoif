import generator.GeneratorStatkowPowietrznych;
import statki.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Implementacja implements Strumienie{
    private List<StatekPowietrzny> statkiPowietrzne;
    private List<NapedzanyStatekPowietrzny> napedzaneStatkiPowietrzne;

    public List<StatekPowietrzny> getStatkiPowietrzne() {
        return statkiPowietrzne;
    }

    public List<NapedzanyStatekPowietrzny> getNapedzaneStatkiPowietrzne() {
        return napedzaneStatkiPowietrzne;
    }

    public Implementacja() {
        this.statkiPowietrzne = GeneratorStatkowPowietrznych.generujStatkiPowietrzne();
        this.napedzaneStatkiPowietrzne = GeneratorStatkowPowietrznych.generujNapedzaneStatkiPowietrzne();
    }

    @Override
    public StatekPowietrzny getNajlzejszyStatekPowietrzny() {
        return statkiPowietrzne.stream()
                .min(Comparator.comparing(StatekPowietrzny::getMasa))
                .get();
    }

    @Override
    public StatekPowietrzny getNajciezszySmiglowiec() {
        return statkiPowietrzne.stream()
                .filter(statekPowietrzny -> statekPowietrzny instanceof Smiglowiec)
                .skip(2)
                .max(Comparator.comparing(StatekPowietrzny::getMasa))
                .get();
    }

    @Override
    public Smiglowiec getSmiglowiecONajmniejszymWirniku() {
        return statkiPowietrzne.stream()
                .filter(statekPowietrzny -> statekPowietrzny instanceof Smiglowiec)
                .skip(1)
                .map(Smiglowiec.class::cast)
                .filter(smiglowiec -> smiglowiec.getTyp().startsWith("Mi"))
                .min(Comparator.comparing(Smiglowiec::getSrednicaWirnika))
                .get();
    }

    @Override
    public Set<StatekPowietrzny> getSamolotyLatajaceWyzejNiz19000M() {
        return statkiPowietrzne.stream()
                .skip(4)
                .filter(statekPowietrzny -> statekPowietrzny instanceof Samolot)
                .map(Samolot.class::cast)
                .filter(samolot -> samolot.getPulap() > 19000 & samolot.getPowierzchniaNosna() >= 25)
                .limit(7)
                .collect(Collectors.toSet());
    }

    @Override
    public List<NapedzanyStatekPowietrzny> getPosortowaneNapedzaneStatkiPowietrznePosortowanePoZasiegu() {
        return napedzaneStatkiPowietrzne.stream()
                .skip(4)
                .filter(napedzanyStatekPowietrzny ->  napedzanyStatekPowietrzny.getPredkoscWznoszenia() >= 100)
                .sorted(Comparator.comparing(NapedzanyStatekPowietrzny::getZasieg).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Szybowiec getSzybowiecONajwiekszejDoskonalosciINajnizszejMasie() {
        return statkiPowietrzne.stream()
                .filter(statekPowietrzny -> statekPowietrzny instanceof Szybowiec)
                .map(Szybowiec.class::cast)
                .sorted(Comparator.comparing(Szybowiec::getDoskonalosc))
                .limit(3)
                .max(Comparator.comparing(Szybowiec::getMasa))
                .get();
    }

    @Override
    public Map<String, StatekPowietrzny> getSamolotyOPowierzchniNosniejWiekszejNiz20() {
        return napedzaneStatkiPowietrzne.stream()
                .filter(napedzanyStatekPowietrzny -> napedzanyStatekPowietrzny instanceof Samolot)
                .map(Samolot.class::cast)
                .filter(samolot -> samolot.getPowierzchniaNosna() > 20)
                .collect(Collectors.toMap(
                        Samolot::getTyp,
                        samolot -> samolot,
                        (samolot1, samolot2) -> {
                            if (samolot1.getMasa() > samolot2.getMasa()) {
                                return samolot2;
                            } else {
                                return samolot1;
                            }
                        }));
    }

    @Override
    public int getSumeDoskonalosciSzybowcowOMasieWiekszejNiz350PoczOdDrugiego() {
        return statkiPowietrzne.stream()
                .skip(1)
                .filter(statekPowietrzny -> statekPowietrzny instanceof Szybowiec & statekPowietrzny.getMasa() >= 350)
                .map(Szybowiec.class::cast)
                .mapToInt(Szybowiec::getDoskonalosc)
                .sum();
    }

    @Override
    public List<StatekPowietrzny> getPierwszePiecSamolotowLubSpadochronowPosortowanychMalejacoPoMasiePoczOd2() {
        return statkiPowietrzne.stream()
                .skip(1)
                .filter(statekPowietrzny -> statekPowietrzny instanceof Szybowiec | statekPowietrzny instanceof Spadochron)
                .sorted(Comparator.comparing(StatekPowietrzny::getMasa).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, StatekPowietrzny> getMapeSpadochronowODopMasieSkoczkaWiekszejNiz85IgnorujDuplikaty() {
        return statkiPowietrzne.stream()
                .filter(statekPowietrzny -> statekPowietrzny instanceof Spadochron)
                .map(Spadochron.class::cast)
                .filter(spadochron -> spadochron.getDopuszczalnaMasaSkoczka() > 85)
                .collect(Collectors.toMap(
                        Spadochron::getDopuszczalnaMasaSkoczka,
                        spadochron -> spadochron
                ));
    }

    @Override
    public void zmienNazwyTypowWZaleznosciOdPierwszychElementow() {
        if (statkiPowietrzne.stream().limit(2).allMatch(statek -> statek instanceof Spadochron) &&
                ((Spadochron) statkiPowietrzne.get(1)).getDopuszczalnaMasaSkoczka() > 100) {

            statkiPowietrzne.forEach(statekPowietrzny -> statekPowietrzny.setTyp(statekPowietrzny.getTyp().toLowerCase()));
        }
    }
}

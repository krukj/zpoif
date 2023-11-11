package generator;

import auta.Samochod;
import auta.SamochodJaponski;
import auta.SamochodNiemiecki;
import auta.SamochodWloski;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Implementacja implements Strumienie{
    List<Samochod> auta;

    public Implementacja() {
        this.auta = GeneratorSamochodow.generateAll();
    }

    @Override
    public Samochod getNajdluzszySamochod() {
        return auta.stream()
                .max(Comparator.comparing(Samochod::getDlogosc))
                .get();
    }

    @Override
    public Samochod getSamochodONajmniejszejSzerokosci() {
        return auta.stream()
                .min(Comparator.comparing(Samochod::getSzerokosc))
                .get();
    }

    @Override
    public Samochod getNajlzejszySamochodWloski() {
        return auta.stream()
                .filter(samochod -> samochod instanceof SamochodWloski)
                .min(Comparator.comparing(Samochod::getMasaWlasna))
                .get();
    }

    @Override
    public List<Samochod> getCoNajwyzej3ZSamochodowMieszczacychSieWGarazu() {
        return auta.stream()
                .filter(samochod -> samochod.getDlogosc() < 500 & samochod.getSzerokosc() < 160 & samochod.getWysokosc() < 150)
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public Set<Samochod> getSamochodyPosortowaneMalejacoWzgledemMasyPomniejszonejOSumeWymiarow() {
        Function<Samochod, Integer> v = s -> s.getMasaWlasna() - (s.getWysokosc() + s.getSzerokosc() + s.getDlogosc());
        return auta.stream()
                .sorted((a,b) -> v.apply(b).compareTo(v.apply(a)))
                .collect(Collectors.toCollection(() -> new TreeSet<>((a,b) -> v.apply(b).compareTo(v.apply(a)))));

    }

    @Override
    public List<Samochod> getSamochodyNieLzejszeNiz1000KgINieSzerszeNiz170() {
        return auta.stream()
                .filter(samochod -> samochod.getMasaWlasna() > 1000 & samochod.getSzerokosc() <= 170)
                .collect(Collectors.toList());
    }

    @Override
    public List<Samochod> getPierwszePiecZPosortowanychMalejacoSNWzglWysok() {
        return auta.stream()
                .filter(samochod -> samochod instanceof SamochodNiemiecki)
                .sorted(Comparator.comparing(Samochod::getWysokosc).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public long getSumaSzerokosciSamochodowJaponskichNieCiezszychNiz1000kgBezDwochPierwszych() {
        return auta.stream()
                .filter(samochod -> samochod instanceof SamochodJaponski
                        & samochod.getMasaWlasna() <= 1000)
                .skip(2)
                .mapToLong(Samochod::getSzerokosc)
                .sum();
    }

    @Override
    public List<Samochod> getCoNajwyzej4ZPosortowanychMalejacoWzglMasyPoczawszyOd10tego() {
        return auta.stream()
                .skip(5)
                .sorted(Comparator.comparing(Samochod::getMasaWlasna).reversed())
                .limit(4)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Samochod> mapujModelNaSamochodTylkoWloskie() {
        return auta.stream()
                .filter(samochod -> samochod instanceof SamochodWloski)
                .collect(Collectors.toMap(
                        Samochod::getMarka,
                        samochod -> samochod,
                        (samochod1, samochod2) -> samochod1
                ));
    }

    @Override
    public Collection<Integer> getJaponskieSamochodyZamienioneNaWartosciIchMasy() {
        return auta.stream()
                .filter(samochod -> samochod instanceof SamochodJaponski)
                .mapToInt(Samochod::getMasaWlasna)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Samochod> getAuta() {
        return auta;
    }
}

import auta.Samochod;
import generator.Implementacja;

import java.util.Map;

public class Demonstrator {
    public static void main(String[] args) {
        Implementacja implementacja = new Implementacja();

        System.out.println("---------------------");
        System.out.println("getNajdluzszySamochod()");
        System.out.println(implementacja.getNajdluzszySamochod());

        System.out.println("---------------------");
        System.out.println("getSamochodONajmniejszejSzerokosci()");
        System.out.println(implementacja.getSamochodONajmniejszejSzerokosci());

        System.out.println("---------------------");
        System.out.println("getNajlzejszySamochodWloski()");
        System.out.println(implementacja.getNajlzejszySamochodWloski());

        System.out.println("---------------------");
        System.out.println("getCoNajwyzej3ZSamochodowMieszczacychSieWGarazu()");
        for (Samochod samochod: implementacja.getCoNajwyzej3ZSamochodowMieszczacychSieWGarazu()) {
            System.out.println(samochod);
        }

        System.out.println("---------------------");
        System.out.println("getSamochodyPosortowaneMalejacoWzgledemMasyPomniejszonejOSumeWymiarow()");
        for (Samochod samochod: implementacja.getSamochodyPosortowaneMalejacoWzgledemMasyPomniejszonejOSumeWymiarow()) {
            System.out.println(samochod);
        }

        System.out.println("---------------------");
        System.out.println("getSamochodyNieLzejszeNiz1000KgINieSzerszeNiz170()");
        for (Samochod samochod: implementacja.getSamochodyNieLzejszeNiz1000KgINieSzerszeNiz170()) {
            System.out.println(samochod);
        }

        System.out.println("---------------------");
        System.out.println("getPierwszePiecZPosortowanychMalejacoSNWzglWysok()");
        for (Samochod samochod: implementacja.getPierwszePiecZPosortowanychMalejacoSNWzglWysok()) {
            System.out.println(samochod);
        }

        System.out.println("---------------------");
        System.out.println("getSumaSzerokosciSamochodowJaponskichNieCiezszychNiz1000kgBezDwochPierwszych()");
        System.out.println(implementacja.getSumaSzerokosciSamochodowJaponskichNieCiezszychNiz1000kgBezDwochPierwszych());

        System.out.println("---------------------");
        System.out.println("getCoNajwyzej4ZPosortowanychMalejacoWzglMasyPoczawszyOd10tego()");
        for (Samochod samochod: implementacja.getCoNajwyzej4ZPosortowanychMalejacoWzglMasyPoczawszyOd10tego()) {
            System.out.println(samochod);
        }
        System.out.println("---------------------");
        System.out.println("mapujModelNaSamochodTylkoWloskie()");
        for (Map.Entry<String, Samochod> entry: implementacja.mapujModelNaSamochodTylkoWloskie().entrySet()) {
            System.out.println(entry.getKey() + " --- " + entry.getValue());
        }

        System.out.println("---------------------");
        System.out.println("getJaponskieSamochodyZamienioneNaWartosciIchMasy()");
        for (Integer integer: implementacja.getJaponskieSamochodyZamienioneNaWartosciIchMasy()) {
            System.out.println(integer);
        }














    }
}
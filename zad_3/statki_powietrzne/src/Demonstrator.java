import statki.NapedzanyStatekPowietrzny;
import statki.Samolot;
import statki.StatekPowietrzny;

import java.util.List;
import java.util.Map;

public class Demonstrator {
    public static void main(String[] args) {
        Implementacja implementacja = new Implementacja();

        System.out.println("-----------");
        System.out.println("getNajlzejszyStatekPowietrzny()");
        System.out.println(implementacja.getNajlzejszyStatekPowietrzny());

        System.out.println("-----------");
        System.out.println("getNajciezszySmiglowiec()");
        System.out.println(implementacja.getNajciezszySmiglowiec());

        System.out.println("-----------");
        System.out.println("getSmiglowiecONajmniejszymWirniku()");
        System.out.println(implementacja.getSmiglowiecONajmniejszymWirniku());

        System.out.println("-----------");
        System.out.println("getSamolotyLatajaceWyzejNiz19000M()");
        for (StatekPowietrzny statekPowietrzny: implementacja.getSamolotyLatajaceWyzejNiz19000M()){
            System.out.println(statekPowietrzny);
        }

        System.out.println("-----------");
        System.out.println("getPosortowaneNapedzaneStatkiPowietrznePosortowanePoZasiegu()");
        for (NapedzanyStatekPowietrzny statek: implementacja.getPosortowaneNapedzaneStatkiPowietrznePosortowanePoZasiegu()) {
            System.out.println(statek);
        }

        System.out.println("-----------");
        System.out.println("getSzybowiecONajwiekszejDoskonalosciINajnizszejMasie()");
        System.out.println(implementacja.getSzybowiecONajwiekszejDoskonalosciINajnizszejMasie());

        System.out.println("-----------");
        System.out.println("getSumeDoskonalosciSzybowcowOMasieWiekszejNiz350PoczOdDrugiego()");
        System.out.println(implementacja.getSumeDoskonalosciSzybowcowOMasieWiekszejNiz350PoczOdDrugiego());

        System.out.println("-----------");
        System.out.println("getPierwszePiecSamolotowLubSpadochronowPosortowanychMalejacoPoMasiePoczOd2();");
        for (StatekPowietrzny statek: implementacja.getPierwszePiecSamolotowLubSpadochronowPosortowanychMalejacoPoMasiePoczOd2()) {
            System.out.println(statek);
        }

        System.out.println("-----------");
        System.out.println("zmienNazwyTypowWZaleznosciOdPierwszychElementow();");
        implementacja.zmienNazwyTypowWZaleznosciOdPierwszychElementow();
        for (StatekPowietrzny statekPowietrzny: implementacja.getStatkiPowietrzne()) {
            System.out.println(statekPowietrzny.getTyp());
        }

        System.out.println("-----------");
        System.out.println("getSamolotyOPowierzchniNosniejWiekszejNiz20()");
        for (Map.Entry<String, StatekPowietrzny> entry: implementacja.getSamolotyOPowierzchniNosniejWiekszejNiz20().entrySet()) {
            System.out.println(entry.getKey() + "----" + entry.getValue());
        }

        System.out.println("-----------");
        System.out.println("getMapeSpadochronowODopMasieSkoczkaWiekszejNiz85IgnorujDuplikaty()");
        for (Map.Entry<Integer, StatekPowietrzny> entry: implementacja.getMapeSpadochronowODopMasieSkoczkaWiekszejNiz85IgnorujDuplikaty().entrySet()) {
            System.out.println(entry.getKey() + "----" + entry.getValue());
        }





    }
}
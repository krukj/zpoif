package solution;

import model.StatekNawodny;
import model.jacht.Jacht;
import model.jacht.JachtMotorowy;
import model.jacht.JachtZaglowy;

import java.util.Map;

public class Demonstrator {
    public static void main(String[] args) {
        Implementacja implementacja = new Implementacja();
        System.out.println("-----------------");
        System.out.println(implementacja.getNajciezszyStatek());
        System.out.println("-----------------");
        System.out.println(implementacja.getStatekONajdluzszejNazwieProducentaNaR());
        System.out.println("-----------------");
        System.out.println(implementacja.getJachtMotorowyONajwiekszejMocySilnika());
        System.out.println("-----------------");
        System.out.println(implementacja.getLekkiJachtKabinowyONajmniejszymOzaglowaniu());
        System.out.println("-----------------");
        for (StatekNawodny jacht: implementacja.getCoNajwyzej11DlugichICiezkichJachtow()) {
            System.out.println(jacht);
        }
        System.out.println("-----------------");
        for (StatekNawodny statekNawodny: implementacja.getStatkiPosortowaneWzgledemDlugosciBez2()) {
            System.out.println(statekNawodny);
        }
        System.out.println("-----------------");
        for (JachtZaglowy jachtZaglowy: implementacja.getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych()) {
            System.out.println(jachtZaglowy);
        }
        System.out.println("-----------------");
        implementacja.oznaczJachtyDobreNaPlycizny();
        System.out.println("-----------------");
        System.out.println(implementacja.get12UnikalnychNazwTypow());
        System.out.println("-----------------");
        for (Map.Entry<String, JachtMotorowy> entry: implementacja.getMapaJachtowMotorowych().entrySet()) {
            System.out.println(entry.getKey() + " --- " + entry.getValue());
        }
        System.out.println("-----------------");
        for (Jacht jacht: implementacja.getJachtyOdkrytopokladoweIMotoroweJednePoDrugich()) {
            System.out.println(jacht);
        }





    }

}

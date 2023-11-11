package solution;

import generator.GeneratorStatkow;
import model.*;
import model.jacht.*;

import java.util.*;
import java.util.stream.Collectors;

public class Implementacja implements Statki{
    List<StatekNawodny> statki;

    public Implementacja() {
        this.statki = GeneratorStatkow.generujStatkiNawodne();
    }
    @Override
    public StatekNawodny getNajciezszyStatek() {
        return statki.stream()
                .max(Comparator.comparing(StatekNawodny::getMasa))
                .get();
    }
    @Override
    public StatekNawodny getStatekONajdluzszejNazwieProducentaNaR() {
        return statki.stream()
                .filter(statek -> statek.getNazwaProducenta().startsWith("R"))
                .max(Comparator.comparing(statek -> statek.getNazwaProducenta().length()))
                .get();
    }
    @Override
    public JachtMotorowy getJachtMotorowyONajwiekszejMocySilnika() {
        return statki.stream()
                .filter(statek -> statek instanceof JachtMotorowy)
                .map(JachtMotorowy.class::cast)
                .max(Comparator.comparing(JachtMotorowy::getMocSilnika))
                .get();

    }
    @Override
    public JachtKabinowy getLekkiJachtKabinowyONajmniejszymOzaglowaniu() {
        return statki.stream()
                .filter(statek -> statek instanceof JachtKabinowy & statek.getMasa() <= 1000)
                .map(JachtKabinowy.class::cast)
                .max(Comparator.comparing(JachtKabinowy::getPowierzchniaZagla))
                .get();
    }
    @Override
    public Set<StatekNawodny> getCoNajwyzej11DlugichICiezkichJachtow() {
        return statki.stream()
                .filter(statek -> statek instanceof Jacht & statek.getMasa() >= 1400 & statek.getDlugosc() > 700)
                .limit(11)
                .collect(HashSet::new, Set::add, Set::addAll);
    }
    @Override
    public List<StatekNawodny> getStatkiPosortowaneWzgledemDlugosciBez2() {
        return statki.stream()
                .skip(2)
                .sorted(Comparator.comparing(StatekNawodny::getDlugosc).reversed())
                .collect(Collectors.toList());
    }
    @Override
    public List<JachtZaglowy> getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych(){
        return statki.stream()
                .filter(statekNawodny -> statekNawodny instanceof JachtZaglowy)
                .map(JachtZaglowy.class::cast)
                .limit(8)
                .skip(2)
                .collect(Collectors.toList());
    }
    @Override
    public void oznaczJachtyDobreNaPlycizny() {
        statki.stream()
                .filter(statekNawodny -> statekNawodny instanceof JachtKabinowy & statekNawodny.getMasa() <= 1300)
                .map(JachtKabinowy.class::cast)
                .filter(statek -> statek.getZanurzenie() <= 30)
                .forEach(statek -> System.out.println("Jachtem " + statek.getTyp() + " wplyniesz na kazda plycizne!"));
    }
    @Override
    public String get12UnikalnychNazwTypow() {
        return statki.stream()
                .filter(statekNawodny -> statekNawodny.getMasa() > 2000 & statekNawodny instanceof Jacht)
                .map(Jacht.class::cast)
                .map(Jacht::getTyp)
                .distinct()
                .skip(3)
                .limit(12)
                .collect(Collectors.joining("-"));
    }
    @Override
    public Map<String, JachtMotorowy> getMapaJachtowMotorowych() {
        return statki.stream()
                .filter(statekNawodny -> statekNawodny instanceof JachtMotorowy)
                .map(JachtMotorowy.class::cast)
                .collect(Collectors.toMap(
                        JachtMotorowy::getTyp,
                        jacht -> jacht,
                        (jacht1, jacht2) -> {
                            if (jacht1.getNazwaProducenta().length() >= jacht2.getNazwaProducenta().length()) {
                                return jacht1;
                            } else {
                                return jacht2;
                            }
                        }

                ));
    }
    @Override
    public List<Jacht> getJachtyOdkrytopokladoweIMotoroweJednePoDrugich(){
        List<JachtOdkrytopokladowy> jachtyOdkrytopokladowe = statki.stream()
                .filter(statekNawodny -> statekNawodny instanceof JachtOdkrytopokladowy)
                .map(JachtOdkrytopokladowy.class::cast)
                .limit(10)
                .toList();
        List<JachtMotorowy> jachtyMotorowe = statki.stream().
                filter(statekNawodny -> statekNawodny instanceof JachtMotorowy)
                .map(JachtMotorowy.class::cast)
                .filter(jachtMotorowy -> jachtMotorowy.getNazwaProducenta().equalsIgnoreCase("regal"))
                .skip(4)
                .limit(4)
                .toList();
        List<Jacht> jachty = new LinkedList<>();
        jachty.addAll(jachtyMotorowe);
        jachty.addAll(jachtyOdkrytopokladowe);
        return jachty;
    }
}

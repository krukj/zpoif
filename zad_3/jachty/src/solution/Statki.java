package solution;

import model.*;
import model.jacht.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Statki {

    StatekNawodny getNajciezszyStatek();
    StatekNawodny getStatekONajdluzszejNazwieProducentaNaR();
    JachtMotorowy getJachtMotorowyONajwiekszejMocySilnika();
    JachtKabinowy getLekkiJachtKabinowyONajmniejszymOzaglowaniu();
    Set<StatekNawodny> getCoNajwyzej11DlugichICiezkichJachtow();
    List<StatekNawodny> getStatkiPosortowaneWzgledemDlugosciBez2();
    List<JachtZaglowy> getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych();
    void oznaczJachtyDobreNaPlycizny();
    String get12UnikalnychNazwTypow();
    Map<String, JachtMotorowy> getMapaJachtowMotorowych();
    List<Jacht> getJachtyOdkrytopokladoweIMotoroweJednePoDrugich();

}
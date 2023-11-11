import statki.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Strumienie {
    StatekPowietrzny getNajlzejszyStatekPowietrzny();
    StatekPowietrzny getNajciezszySmiglowiec();
    Smiglowiec getSmiglowiecONajmniejszymWirniku();
    Set<StatekPowietrzny> getSamolotyLatajaceWyzejNiz19000M();
    public List<NapedzanyStatekPowietrzny> getPosortowaneNapedzaneStatkiPowietrznePosortowanePoZasiegu();
    Szybowiec getSzybowiecONajwiekszejDoskonalosciINajnizszejMasie();
    Map<String, StatekPowietrzny> getSamolotyOPowierzchniNosniejWiekszejNiz20();
    int getSumeDoskonalosciSzybowcowOMasieWiekszejNiz350PoczOdDrugiego();
    List<StatekPowietrzny> getPierwszePiecSamolotowLubSpadochronowPosortowanychMalejacoPoMasiePoczOd2();
    Map<Integer, StatekPowietrzny> getMapeSpadochronowODopMasieSkoczkaWiekszejNiz85IgnorujDuplikaty();
    void zmienNazwyTypowWZaleznosciOdPierwszychElementow();
}

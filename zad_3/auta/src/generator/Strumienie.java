package generator;

import auta.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Strumienie {

    Samochod getNajdluzszySamochod();
    Samochod getSamochodONajmniejszejSzerokosci();
    Samochod getNajlzejszySamochodWloski();
    List<Samochod> getCoNajwyzej3ZSamochodowMieszczacychSieWGarazu();
    Set<Samochod> getSamochodyPosortowaneMalejacoWzgledemMasyPomniejszonejOSumeWymiarow();

    List<Samochod> getSamochodyNieLzejszeNiz1000KgINieSzerszeNiz170();
    List<Samochod> getPierwszePiecZPosortowanychMalejacoSNWzglWysok();
    long getSumaSzerokosciSamochodowJaponskichNieCiezszychNiz1000kgBezDwochPierwszych();

    List<Samochod> getCoNajwyzej4ZPosortowanychMalejacoWzglMasyPoczawszyOd10tego();
    Map<String, Samochod> mapujModelNaSamochodTylkoWloskie();
    Collection<Integer> getJaponskieSamochodyZamienioneNaWartosciIchMasy();

}

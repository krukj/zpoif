package pl.edu.pw.mini.zpoif.task4a.solution;

import pl.edu.pw.mini.zpoif.task4a.Generator;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.Szybowiec;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.Wywietrznik;

import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.uchwyt.Uchwyt;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public void task1() throws Exception {
        Class klasa = Class.forName("pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.Wywietrznik");
        Constructor[] constructors = klasa.getConstructors();
        for (Constructor con: constructors) {
            if (con.getParameterCount() == 0) {
                Wywietrznik wywietrznik = (Wywietrznik) klasa.newInstance();
            }
        }
    }

    public static void task2() throws Exception {
        Szybowiec szybowiec = Generator.utworzPuchacza();
        Class szybowiecClass = szybowiec.getClass();

        Field kabinaPole = szybowiecClass.getDeclaredField("kabinaPierwsza");
        kabinaPole.setAccessible(true);
        Object kabina = kabinaPole.get(szybowiec);
        Class kabinaClass = kabina.getClass();

        Field tablicaPole = kabinaClass.getSuperclass().getDeclaredField("tablicaPrzyrzadow");
        tablicaPole.setAccessible(true);
        Object tablicaPrzyrzadow = tablicaPole.get(kabina);
        Class tablicaClass = tablicaPrzyrzadow.getClass();

        Field wysokosciomierzPole = tablicaClass.getDeclaredField("wysokosciomierz");
        wysokosciomierzPole.setAccessible(true);
        Object wysokosciomierz = wysokosciomierzPole.get(tablicaPrzyrzadow);
        Class wysokosciomierzClass = wysokosciomierz.getClass();

        Field qnhPole = wysokosciomierzClass.getDeclaredField("qnh");
        qnhPole.setAccessible(true);

        if ((Integer) qnhPole.get(wysokosciomierz) == 0) {
            Method setQNHMethod = wysokosciomierzClass.getDeclaredMethod("setQNH", int.class);
            setQNHMethod.setAccessible(true);
            setQNHMethod.invoke(wysokosciomierz, 1013);
        }
    }


    public void task3() throws Exception {
        Szybowiec szybowiec = Generator.utworzPuchacza();

        Field kabinaPole = szybowiec.getClass().getDeclaredField("kabinaPierwsza");
        kabinaPole.setAccessible(true);

        Object kabinaInstance = kabinaPole.get(szybowiec);

        Field uchwytPole = kabinaInstance.getClass().getDeclaredField("uchwytHamulcaKola");
        uchwytPole.setAccessible(true);

        Object uchwytInstance = uchwytPole.get(kabinaInstance);

        Field hamulecKolaPole = uchwytInstance.getClass().getDeclaredField("hamulecKola");
        hamulecKolaPole.setAccessible(true);

        Object hamulecKolaInstance = hamulecKolaPole.get(uchwytInstance);

        Class nadklasa = hamulecKolaInstance.getClass().getSuperclass();
        Object nowyHamulecKola = nadklasa.newInstance();

        hamulecKolaPole.set(uchwytInstance, nowyHamulecKola);
    }



    public void task4() throws Exception {
        Szybowiec szybowiec = Generator.utworzPuchacza();
        Field kabinaPole = szybowiec.getClass().getDeclaredField("kabinaDruga");
        kabinaPole.setAccessible(true);

        Object kabinaInstance = kabinaPole.get(szybowiec);

        Field[] pola = kabinaInstance.getClass().getDeclaredFields();

        for (Field field : pola) {
            field.setAccessible(true);

            if (Uchwyt.class.isAssignableFrom(field.getType())) {
                Field kolorPole = field.getType().getDeclaredField("kolorUchwytu");
                kolorPole.setAccessible(true);

                Uchwyt.Kolor kolorUchwytu = (Uchwyt.Kolor) kolorPole.get(field.get(kabinaInstance));

                if (kolorUchwytu == Uchwyt.Kolor.ZOLTY) {
                    System.out.println(field.getName());
                }
            }
        }
    }

    public void task5() throws Exception {
        Szybowiec szybowiec = Generator.utworzPuchacza();

        Field kabinaPole = szybowiec.getClass().getSuperclass().getDeclaredField("kabinaPierwsza");
        kabinaPole.setAccessible(true);

        Object kabinaInstance = kabinaPole.get(szybowiec);

        Field uczenPole = kabinaInstance.getClass().getDeclaredField("pilot");
        uczenPole.setAccessible(true);

        Object uczenInstance = uczenPole.get(kabinaInstance);

        Field mottoPole = uczenInstance.getClass().getDeclaredField("motto");
        mottoPole.setAccessible(true);

        Field tablicaPole = kabinaInstance.getClass().getDeclaredField("tablicaPrzyrzadow");
        tablicaPole.setAccessible(true);

        Object tablicaInstance = tablicaPole.get(kabinaInstance);

        Field napisPole = tablicaInstance.getClass().getDeclaredField("napis");
        napisPole.setAccessible(true);

        mottoPole.set(uczenInstance, napisPole.get(tablicaInstance));
    }

    public void task6() throws Exception {
        Szybowiec szybowiec = Generator.utworzPuchacza();

        Field kabinaPole = szybowiec.getClass().getDeclaredField("kabinaPierwsza");
        kabinaPole.setAccessible(true);

        Object kabinaInstance = kabinaPole.get(szybowiec);

        Field uczenPole = kabinaInstance.getClass().getDeclaredField("pilot");
        uczenPole.setAccessible(true);

        if (Modifier.isAbstract(uczenPole.getType().getModifiers())) {
            Class klasaUczen = Class.forName("pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.inne.Uczen");
            Object uczen = klasaUczen.newInstance();

            Field imiePole = klasaUczen.getDeclaredField("imie");
            imiePole.setAccessible(true);
            imiePole.set(uczen, "Robert");

            Field nazwiskoPole = klasaUczen.getDeclaredField("nazwisko");
            nazwiskoPole.setAccessible(true);
            nazwiskoPole.set(uczen, "Maklowicz");

            Field mottoPole = klasaUczen.getDeclaredField("prywatneMotto");
            mottoPole.setAccessible(true);
            mottoPole.set(uczen, "zycie mnie mnie");

            Field licznikPole = klasaUczen.getDeclaredField("licznikLotowSamodzielnych");
            licznikPole.setAccessible(true);
            licznikPole.set(uczen, 1001);

            uczenPole.set(kabinaInstance, uczen);
        }
    }

    public void task7() throws Exception {
        Szybowiec szybowiec = Generator.utworzPuchacza();

        Field kabinaPole = szybowiec.getClass().getDeclaredField("kabinaPierwsza");
        kabinaPole.setAccessible(true);

        Object kabinaInstance = kabinaPole.get(szybowiec);

        Field uchwytPole = kabinaInstance.getClass().getDeclaredField("uchwytHamulcaKola");
        uchwytPole.setAccessible(true);

        Object uchwytInstance = uchwytPole.get(kabinaInstance);

        Field hamulecKolaPole = uchwytInstance.getClass().getDeclaredField("hamulecKola");
        hamulecKolaPole.setAccessible(true);

        Object hamulecKolaInstance = hamulecKolaPole.get(uchwytInstance);

        Class nadklasa = hamulecKolaInstance.getClass().getSuperclass();
        int metody = nadklasa.getDeclaredMethods().length;
        Class maxKlasa = nadklasa;
        while (nadklasa != null) {
            if (nadklasa.getDeclaredMethods().length >= metody) {
                metody = nadklasa.getDeclaredMethods().length;
                maxKlasa = nadklasa;
            }
            nadklasa = nadklasa.getSuperclass();
        }
        System.out.println(maxKlasa.getSimpleName());
    }

    public static void task8() throws Exception {
        Szybowiec szybowiec = Generator.utworzPuchacza();

        Field kabinaPole = szybowiec.getClass().getDeclaredField("kabinaDruga");
        kabinaPole.setAccessible(true);

        Object kabinaInstance = kabinaPole.get(szybowiec);

        Field instruktorPole = kabinaInstance.getClass().getDeclaredField("pilot");
        instruktorPole.setAccessible(true);

        Object instruktorInstance = instruktorPole.get(szybowiec);
        Method[] metody = instruktorInstance.getClass().getDeclaredMethods();
        List<Method> metodyDziedziczone = Arrays.stream(instruktorInstance.getClass().getSuperclass().getDeclaredMethods()).toList();
        for (Method metoda: metody) {
            if (metoda.isAccessible()) {
                if (metoda.getName().equals("udzielUwagi")) {
                    if (!metodyDziedziczone.contains(metoda)) {
                        Parameter[] parametry = metoda.getParameters();
                        List<Parameter> parametryBoolean = new ArrayList<>();
                        for (Parameter parameter : parametry) {
                            if (parameter.getType() == Boolean.class) {
                                parametryBoolean.add(parameter);
                            }
                        }
                        if (parametryBoolean.size() <= 1) {
                            for (Parameter p : parametryBoolean) {
                                metoda.invoke(szybowiec, true);
                            }
                        }
                    }

                }
            }
        }
    }

    public void task9() throws Exception {
        Szybowiec szybowiec = Generator.utworzPuchacza();

        Field kabinaPole = szybowiec.getClass().getDeclaredField("kabinaDruga");
        kabinaPole.setAccessible(true);

        Object kabinaInstance = kabinaPole.get(szybowiec);

        Field tablcaPole = kabinaInstance.getClass().getDeclaredField("tabliczkaInformacyjna");
        tablcaPole.setAccessible(true);
        Object tablicaInstance = tablcaPole.get(szybowiec);

        Field instruktorPole = kabinaInstance.getClass().getDeclaredField("pilot");
        instruktorPole.setAccessible(true);
        Object instruktorInstance = instruktorPole.get(szybowiec);

        Field notatkiPole = instruktorInstance.getClass().getDeclaredField("notatki");
        notatkiPole.setAccessible(true);

        Object notatkiInstance = notatkiPole.get(szybowiec);


    }
}

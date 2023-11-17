package pl.edu.pw.mini.zpoif.fifth.solution;

import pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda;
import pl.edu.pw.mini.zpoif.fifth.elevator.UniwersalnySterownikWindy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.stream.Stream;

public class Demonstrator {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        System.out.println("---task1---");
        System.out.println();
        task1();

        System.out.println();
        System.out.println("---task2---");
        System.out.println();
        task2();

        System.out.println();
        System.out.println("---task3---");
        System.out.println();
        task3();

        System.out.println();
        System.out.println("---task4---");
        System.out.println();
        task4();

        System.out.println();
        System.out.println("---task5---");
        System.out.println();
        task5();

        System.out.println();
        System.out.println("---task6---");
        System.out.println();
        task6();

        System.out.println();
        System.out.println("---task7---");
        System.out.println();
        task7();

        System.out.println();
        System.out.println("---task8---");
        System.out.println();
        task8(MiNIWinda.class);

        System.out.println();
        System.out.println("---task9---");
        System.out.println();
        task9();

        System.out.println();
        System.out.println("---task10---");
        System.out.println();
        task10();
    }
    public static void task1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class klasa = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        MiNIWinda winda = (MiNIWinda) klasa.newInstance();
        System.out.println("Utworzono nowy obiekt klasy MiNiWinda");
        System.out.println(winda);
    }

    public static void task2() throws ClassNotFoundException {
        Class klasa = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        Constructor[] kontruktory = klasa.getDeclaredConstructors();
        System.out.println("Konstruktorow jest: " + kontruktory.length);
        Constructor konstruktor = Stream.of(kontruktory)
                .max((a, b) -> Integer.valueOf(a.getParameterCount()).compareTo(b.getParameterCount()))
                .orElseGet(null);
        if (konstruktor != null) {
            System.out.println("Konstruktor o najwiekszej liczbie parametrow: " + konstruktor.getName());
            Stream.of(konstruktor.getParameters())
                    .forEach(p -> System.out.println("nazwa parametru: " + p.getName() + " typ: " + p.getType()));
        }
    }

    public static void task3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class klasa = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        Object producent = klasa.getDeclaredField("PRODUCENT");
        System.out.println("Wartosc pola PRODUCENT: " + producent);
    }

    public static void task4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class klasa = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        MiNIWinda winda = (MiNIWinda) klasa.newInstance();
        Field kolor = winda.getClass().getDeclaredField("kolor");
        kolor.setAccessible(true);
        System.out.println("Wartosc pola kolor: " + kolor.get(winda));
        kolor.setAccessible(false);
    }

    public static void task5() throws ClassNotFoundException {
        Class klasa = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        Stream.of(klasa.getMethods())
                .filter(metoda -> klasa != metoda.getDeclaringClass())
                .forEach(metoda -> {
                    System.out.println("metoda: " + metoda.getName() + " nadklasa: " + metoda.getDeclaringClass().getCanonicalName());
                });
    }

    public static void task6() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class klasa = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        MiNIWinda winda = (MiNIWinda) klasa.newInstance();
        Field sterownik = klasa.getDeclaredField("sterownikWindy");
        sterownik.setAccessible(true);
        System.out.println("Klasa instancji przypisanej do pola sterownik: " + sterownik.get(winda).getClass().getSimpleName());
    }

    public static void task7() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class klasa = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        Class nadklasa = klasa.getSuperclass();
        Package pakiet = nadklasa.getPackage();
        System.out.println("Nazwa pakietu nadklasy klasy MiNiWinda: " + pakiet.getName());
    }

    public static void task8(Class klasa) {
        Class nadklasa = klasa.getSuperclass();
        System.out.println("Nadklasy: ");
        while (nadklasa != null) {
            System.out.println(nadklasa.getSimpleName());
            System.out.println("liczba metod: " + nadklasa.getMethods().length);
            nadklasa = nadklasa.getSuperclass();
        }
    }

    public static void task9() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class klasa = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        MiNIWinda winda = (MiNIWinda) klasa.newInstance();
        Field sterownik = klasa.getDeclaredField("sterownikWindy");
        sterownik.setAccessible(true);
        sterownik.set(winda, UniwersalnySterownikWindy.class.newInstance());
        Field nowySterownik = klasa.getDeclaredField("sterownikWindy");
        nowySterownik.setAccessible(true);
        System.out.println("Podmieniono " + sterownik + " na " + nowySterownik);
    }

    public static void task10() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class klasa = Class.forName("pl.edu.pw.mini.zpoif.fifth.elevator.MiNIWinda");
        MiNIWinda winda = (MiNIWinda) klasa.newInstance();
        Field poleKabina = klasa.getDeclaredField("kabina");
        poleKabina.setAccessible(true);
        Object kabina = poleKabina.get(winda);
        Field polePanel = kabina.getClass().getDeclaredField("panelSterowniczy");
        polePanel.setAccessible(true);
        Object panel = polePanel.get(kabina);
        Field poleSygnal = panel.getClass().getDeclaredField("sygnalPowitalny");
        poleSygnal.setAccessible(true);
        poleSygnal.set(panel, "Guten morgen!");
        System.out.println("ustawiono sygnal powitalny: " + poleSygnal.get(panel));
        Method metoda = panel.getClass().getDeclaredMethod("getSygnalPowitalny", String.class);
        metoda.setAccessible(true);
        metoda.invoke(panel, "  ");
    }

}
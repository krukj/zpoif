package pl.edu.pw.mini.zpoif.task4b.solution;

import pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka;

import java.lang.reflect.*;

public class Demonstrator {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        System.out.println("---task1---");
        System.out.println();
        WygodnaBudka budka = task1();

        System.out.println();
        System.out.println("---task2---");
        System.out.println();
        task2(budka);

        System.out.println();
        System.out.println("---task3---");
        System.out.println();
        task3(budka);

        System.out.println();
        System.out.println("---task4---");
        System.out.println();
        task4(budka);

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
        task7(budka);

        System.out.println();
        System.out.println("---task8---");
        System.out.println();
        task8();

        System.out.println();
        System.out.println("---task9---");
        System.out.println();
        task9(budka);
    }
    public static WygodnaBudka task1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
       Class klasa = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
       WygodnaBudka budka = (WygodnaBudka) klasa.newInstance();
       System.out.println("Utworzono obiekt klasy WygodnaBudka");
       System.out.println(budka);
       return budka;
    }

    public static void task2(WygodnaBudka budka) throws NoSuchFieldException, IllegalAccessException {
        Field f = budka.getClass().getDeclaredField("bazgrol");
        f.setAccessible(true);
        System.out.println("bazgrol: " + f.get(budka));
        f.setAccessible(false);
    }

    public static void task3(WygodnaBudka budka) throws NoSuchFieldException, IllegalAccessException {
        Field uniwersalny = budka.getClass().getSuperclass().getDeclaredField("UNIWERSALNY_SZYFR_DO_SEJFU");
        Field szyfr = budka.getClass().getDeclaredField("szyfrDoSejfu");
        uniwersalny.setAccessible(true);
        szyfr.setAccessible(true);
        szyfr.set(budka, uniwersalny.get(budka));
        System.out.println("Ustawiono pole " + szyfr.getName() + " wartoscia pola " + uniwersalny.getName());
    }

    public static void task4(WygodnaBudka budka) throws InvocationTargetException, IllegalAccessException {
        Method[] metody = budka.getClass().getDeclaredMethods();
        for (Method metoda: metody) {
            if (metoda.getParameterCount() == 0 & metoda.getReturnType() == Integer.class) {
                Integer wynik = (Integer) metoda.invoke(budka);
                System.out.println("metoda: " + metoda.getName());
                System.out.println("wynik: " + wynik);
                break;
            }
        }
    }

    public static void task5() throws ClassNotFoundException, NoSuchFieldException {
        Class budka = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
        Field field = budka.getDeclaredField("dobreWyrko");
        Class fieldType = field.getType();
        System.out.println("Nadklasy: ");
        System.out.println();
        while (fieldType != null) {
            System.out.println(fieldType.getSimpleName());
            fieldType = fieldType.getSuperclass();
        }
    }

    public static void task6() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class budka = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
        Constructor[] constructors = budka.getDeclaredConstructors();
        Constructor con = null;
        for (Constructor constructor: constructors) {
            if (constructor.getParameterCount() == 2) {
                if (constructor.getParameterTypes()[0] == String.class &
                constructor.getParameterTypes()[1] == String.class) {
                    con = constructor;
                    break;
                }
            }
        }
        if (con != null) {
            Object instancja = con.newInstance("Super", "Dobre graty");
            System.out.println("Utworzono instancje klasy: " + instancja);
            Field nazwa = instancja.getClass().getDeclaredField("nazwa");
            nazwa.setAccessible(true);
            System.out.println("nazwa: " + nazwa.get(instancja));
            Field producent = instancja.getClass().getDeclaredField("producent");
            producent.setAccessible(true);
            System.out.println("producent: " + producent.get(instancja));
        } else {
            System.out.println("Nie znaleziono odpowiedniego konstruktora");
        }
    }

    public static void task7(WygodnaBudka budka) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field sejfField = budka.getClass().getDeclaredField("sejf");
        sejfField.setAccessible(true);
        Object sejfObject = sejfField.get(budka);
        Method m = sejfObject.getClass().getDeclaredMethod("open", String.class);
        m.setAccessible(true);
        Field szyfr = budka.getClass().getDeclaredField("szyfrDoSejfu");
        szyfr.setAccessible(true);
        m.invoke(sejfObject, szyfr.get(budka));
    }

    public static void task8() throws ClassNotFoundException {
        Class wygodnaBudka = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
        Class nadklasa = wygodnaBudka.getSuperclass();
        Class[] klasy = nadklasa.getDeclaredClasses();
        System.out.println("Nadklasy klasy WygodnaBudka o zasiegu protected: ");
        for (Class klasa: klasy) {
            if (Modifier.isProtected(klasa.getModifiers())) {
                System.out.println(klasa.getSimpleName());
            }
        }
    }

    public static void task9(WygodnaBudka budka) throws IllegalAccessException {
        Field[] polaKlasy = budka.getClass().getDeclaredFields();
        Integer suma1 = 0;
        for (Field field: polaKlasy) {
            if (field.getType() == Integer.class) {
                field.setAccessible(true);
                suma1 += (Integer) field.get(budka);
            }
        }
        Class nadklasa = budka.getClass().getSuperclass();
        Field[] polaNadklasy = nadklasa.getDeclaredFields();
        int suma2 = 0;
        for (Field field: polaNadklasy) {
            if (field.getType() == Integer.class) {
                field.setAccessible(true);
                suma2 += (Integer) field.get(budka);
            }
        }
        System.out.println("w klasie: " + suma1);
        System.out.println("w nadklasie: " + suma2);
        System.out.println("Suma wartosci pol z nadklasy - suma wartosci pol z klasy = " + (suma2 - suma1));
    }

}
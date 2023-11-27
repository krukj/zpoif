package pl.edu.pw.mini.zpoif.task5.solution;

import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import pl.edu.pw.mini.zpoif.task5.people.special.ButtonMan;

import java.util.Set;

public class Demonstrator {
    public static void main(String... args) throws Exception {
        Implementation implementation = new Implementation();
        System.out.println("-----------");
        System.out.println("createImportantMafiaWorkers");
        Set<MafiaWorker> mafiaWorkers = implementation.createImportantMafiaWorkers();
        mafiaWorkers.forEach(System.out::println);

        System.out.println("-----------");
        System.out.println("createPrimaryMafiaWorker");
        MafiaWorker primaryMafiaWorker = implementation.createPrimaryMafiaWorker();
        System.out.println(primaryMafiaWorker);

        System.out.println("-----------");
        System.out.println("createPrioritizedPrimaryMafiaWorker");
        MafiaWorker prioritizedPrimaryMafiaWorker = implementation.createPrioritizedPrimaryMafiaWorker();
        System.out.println(prioritizedPrimaryMafiaWorker);

        System.out.println("-----------");
        System.out.println("encryptFields");
        implementation.encryptFields(mafiaWorkers);

        System.out.println("-----------");
        System.out.println("getKiller");
        ButtonMan killer = implementation.getKiller("czterdziesci", "i cztery");
        System.out.println(killer);

        System.out.println("-----------");
        System.out.println("goButtonMan");
        implementation.goButtonMan(mafiaWorkers);



    }
}

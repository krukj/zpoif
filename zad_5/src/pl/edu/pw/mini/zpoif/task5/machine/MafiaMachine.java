package pl.edu.pw.mini.zpoif.task5.machine;

import java.util.Set;

import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import pl.edu.pw.mini.zpoif.task5.people.special.ButtonMan;

public abstract class MafiaMachine {

	protected abstract Set<MafiaWorker> createImportantMafiaWorkers() throws Exception;
	protected abstract MafiaWorker createPrimaryMafiaWorker() throws Exception;
	protected abstract MafiaWorker createPrioritizedPrimaryMafiaWorker() throws Exception;
	protected abstract void encryptFields(Set<MafiaWorker> workers) throws Exception;
	protected abstract ButtonMan getKiller(String name, String surname) throws Exception;
	protected abstract void init(MafiaWorker mafiaWorker) throws Exception;
	protected abstract void goButtonMan(Set<MafiaWorker> buttonMan) throws Exception;
	protected abstract void retreat(ButtonMan buttonMan) throws Exception;

}

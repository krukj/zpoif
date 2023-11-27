package pl.edu.pw.mini.zpoif.task5.people.special;

import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import pl.edu.pw.mini.zpoif.task5.solution.annotations.ImportantWorker;
import pl.edu.pw.mini.zpoif.task5.solution.annotations.InitMe;
import pl.edu.pw.mini.zpoif.task5.solution.annotations.PrimaryMafiaWorker;

@ImportantWorker(quantity = 1)
@PrimaryMafiaWorker(priority = 1)
public class GodFather extends MafiaWorker {

	protected Wallet wallet;

	@InitMe
	protected class Wallet {

		private int value;

		public Wallet(int value) {
			this.value = value;
		}

	}

	public GodFather() {
		super();
	}

	public GodFather(String name, String surname) {
		super(name, surname);
	}

	public GodFather(String name) {
		super(name);
	}

}

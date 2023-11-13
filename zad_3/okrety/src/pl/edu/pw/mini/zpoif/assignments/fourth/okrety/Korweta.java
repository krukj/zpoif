package pl.edu.pw.mini.zpoif.assignments.fourth.okrety;

public class Korweta extends Okret {
	
	protected int liczbaWyrzutniRakiet;

	public Korweta(String nazwa, int wypornosc, float dlugosc, int zasieg, int predkosc, int mocNapedu,
			int liczbaWyrzutniRakiet) {
		super(nazwa, wypornosc, dlugosc, zasieg, predkosc, mocNapedu);
		this.liczbaWyrzutniRakiet = liczbaWyrzutniRakiet;
	}

	@Override
	public String toString() {
		return "Korweta{" +
				"liczbaWyrzutniRakiet=" + liczbaWyrzutniRakiet +
				", nazwa='" + nazwa + '\'' +
				", wypornosc=" + wypornosc +
				", dlugosc=" + dlugosc +
				", zasieg=" + zasieg +
				", predkosc=" + predkosc +
				", mocNapedu=" + mocNapedu +
				'}';
	}
}

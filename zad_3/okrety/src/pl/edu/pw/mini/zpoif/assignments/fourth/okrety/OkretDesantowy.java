package pl.edu.pw.mini.zpoif.assignments.fourth.okrety;

public class OkretDesantowy extends Okret {

	protected float zanurzenie;

	public OkretDesantowy(String nazwa, int wypornosc, float dlugosc, int zasieg, int predkosc, int mocNapedu,
			float zanurzenie) {
		super(nazwa, wypornosc, dlugosc, zasieg, predkosc, mocNapedu);
		this.zanurzenie = zanurzenie;
	}

	@Override
	public String toString() {
		return "OkretDesantowy{" +
				"zanurzenie=" + zanurzenie +
				", nazwa='" + nazwa + '\'' +
				", wypornosc=" + wypornosc +
				", dlugosc=" + dlugosc +
				", zasieg=" + zasieg +
				", predkosc=" + predkosc +
				", mocNapedu=" + mocNapedu +
				'}';
	}
}

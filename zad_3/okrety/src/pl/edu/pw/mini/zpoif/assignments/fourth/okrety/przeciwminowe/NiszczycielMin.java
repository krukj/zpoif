package pl.edu.pw.mini.zpoif.assignments.fourth.okrety.przeciwminowe;

public class NiszczycielMin extends OkretTarczyPrzeciwminowej {

	public NiszczycielMin(String nazwa, int wypornosc, float dlugosc, int zasieg, int predkosc, int mocNapedu) {
		super(nazwa, wypornosc, dlugosc, zasieg, predkosc, mocNapedu);
	}

	@Override
	public String toString() {
		return "NiszczycielMin{" +
				"nazwa='" + nazwa + '\'' +
				", wypornosc=" + wypornosc +
				", dlugosc=" + dlugosc +
				", zasieg=" + zasieg +
				", predkosc=" + predkosc +
				", mocNapedu=" + mocNapedu +
				'}';
	}
}

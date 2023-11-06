import generator.Generator;
import radios.RadioStation;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        List<RadioStation> radios = generator.getRadioStations();
        for (RadioStation radioStation: radios) {
            System.out.println(radioStation);
        }
        System.out.println("----------");
        generator.printNames();
        System.out.println("----------");
        generator.channel19();
        for (RadioStation radioStation: radios) {
            System.out.println(radioStation);
        }
        System.out.println("----------");
        RadiosSorter.sortRadiosByName(radios);
        for (RadioStation radioStation: radios) {
            System.out.println(radioStation);
        }
        System.out.println("----------");
        RadiosSorter.sortRadiosByChannel(radios);
        for (RadioStation radioStation: radios) {
            System.out.println(radioStation);
        }

    }
}
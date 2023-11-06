import media.MassMedia;
import media.Newspaper;
import media.electronic.Radio;
import media.electronic.TV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generator {
    Random random = new Random();
    private List<MassMedia> media;

    public Generator() {
        this.media = generate();
    }

    @FunctionalInterface
    interface RadioGenerator {
        Radio create();
    }
    @FunctionalInterface
    interface TVGenerator {
        TV create();
    }
    @FunctionalInterface
    interface NewspaperGenerator {
        Newspaper create();
    }
    private List<MassMedia> generate() {
        List<String> TVNames = Arrays.asList("CNNW", "FoxNews", "NBCC", "NHHK", "Jetix2", "Khabara TV", "UTVa");
        List<String> radioNames = Arrays.asList("Rouge FMa", "City FM 899", "Radio Hauraki2", "JFNK", "Today FM news");
        List<String> newspaperNames = Arrays.asList("El Universala", "La Prensaco", "Tal Cualana", "Barbadian2", "Pepper PunchX");

        TVGenerator tvGenerator = () -> new TV(
                TVNames.get(random.nextInt(TVNames.size())),
                random.nextInt(1, 201),
                random.nextInt(1, 500000001),
                random.nextInt(1, 101),
                random.nextBoolean()
        );
        RadioGenerator radioGenerator = () -> new Radio(
                radioNames.get(random.nextInt(radioNames.size())),
                random.nextInt(1, 101),
                random.nextInt(1, 1000000000),
                random.nextInt(1, 101)
        );
        NewspaperGenerator newspaperGenerator = () -> new Newspaper(
                newspaperNames.get(random.nextInt(newspaperNames.size())),
                random.nextInt(1, 221),
                random.nextInt(1, 100000),
                random.nextInt(1, 101)
        );
        List<MassMedia> media = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            media.add(tvGenerator.create());
            media.add(radioGenerator.create());
            media.add(newspaperGenerator.create());
        }
        return media;
    }

    public List<MassMedia> getMedia() {
        return media;
    }
}

package generator;

import radios.CB.CarCBRadio;
import radios.CB.HandCBRadio;
import radios.CB.StationaryCBRadio;
import radios.Modulation;
import radios.RadioStation;
import radios.ShortWaveRadio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Generator {
    private List<RadioStation> radioStations;
    public Generator() {
        this.radioStations = generate();
    }

    @FunctionalInterface
    interface HandCBRadioGenerator {
        HandCBRadio create(int channel);
    }
    @FunctionalInterface
    interface CarCBRadioGenerator {
        CarCBRadio create(int channel);
    }
    @FunctionalInterface
    interface StationaryCBRadioGenerator {
        StationaryCBRadio create(int channel, Modulation modulation);
    }
    @FunctionalInterface
    interface RadioGenerator {
        ShortWaveRadio create();
    }
    public List<RadioStation> generate(){
        Random random = new Random();
        List<String> carRadiosNames = Arrays.asList( "Cobra", "Zodiac", "President", "Uniden", "Midland", "Stryker");
        List<String> handRadiosNames = Arrays.asList("ALAN", "Motorola");
        List<String> otherNames = Arrays.asList("STABO", "TEAMBSG", "RadMor", "Albrecht", "PNI_ESCORT", "CRTMIKE", "Galaxy",
                "PMR", "Midland");
        List<Modulation> modulations = List.of(Modulation.values());

        HandCBRadioGenerator handCBRadioGenerator = (channel -> new HandCBRadio(
                handRadiosNames.get(random.nextInt(handRadiosNames.size())),
                26.950 + channel * 0.01,
                modulations.get(random.nextInt(modulations.size())),
                channel,
                random.nextBoolean())
        );
        CarCBRadioGenerator carCBRadioGenerator = (channel -> new CarCBRadio(
                carRadiosNames.get(random.nextInt(carRadiosNames.size())),
                26.950 + channel * 0.01,
                modulations.get(random.nextInt(modulations.size())),
                channel,
                random.nextBoolean())
        );
        StationaryCBRadioGenerator stationaryCBRadioGenerator = ((channel, modulation) -> new StationaryCBRadio(
                otherNames.get(random.nextInt(otherNames.size())),
                26.950 + channel * 0.01,
                modulation,
                channel
        ));
        RadioGenerator radioGenerator = () -> new ShortWaveRadio(
                otherNames.get(random.nextInt(otherNames.size())),
                random.nextInt(1, 101),
                modulations.get(random.nextInt(modulations.size()))
        );
        List<RadioStation> radioStations = new ArrayList<>();
        int n = random.nextInt(1, 6);
        for (int i = 0; i < n; i++) {
            radioStations.add(handCBRadioGenerator.create(random.nextInt(1, 41)));
            radioStations.add(carCBRadioGenerator.create(random.nextInt(1, 41)));
            radioStations.add(stationaryCBRadioGenerator.create(random.nextInt(1, 41), modulations.get(random.nextInt(modulations.size()))));
            radioStations.add(radioGenerator.create());
        }
        return radioStations;
    }
    public void printNames(){
        Consumer<RadioStation> lambda = radioStation -> {
            System.out.println("Producer's name: " + radioStation.getProducer() + " length: " +radioStation.getProducer().length());
        };
        radioStations.forEach(lambda);
    }
    public void channel19(){
        Consumer<RadioStation> lambda = radioStation -> {
            if (radioStation instanceof CarCBRadio) {
                ((CarCBRadio) radioStation).setChannelAndFrequency(19);
            }
        };
        radioStations.forEach(lambda);
    }

    public List<RadioStation> getRadioStations() {
        return radioStations;
    }
}

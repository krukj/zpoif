import radios.CB.StationaryCBRadio;
import radios.ShortWaveRadio;

import java.util.Random;
import java.util.function.Consumer;

import static java.lang.Math.sin;

public class Consuming {
    public static void main(String[] args) {
        Random random = new Random();
        Consumer<String> startsWithA = s -> s.startsWith("A");
        Consumer<Integer> sinus = x -> sin(x);
        Consumer<StationaryCBRadio> stationaryCBRadioConsumer = stationaryCBRadio -> stationaryCBRadio.setChannelAndFrequency(random.nextInt(1, 41));
        Consumer<ShortWaveRadio> shortWaveRadioConsumer = shortWaveRadio -> shortWaveRadio.setFrequencyAndFM(random.nextDouble(1, 100));
    }
}

import radios.CB.HandCBRadio;
import radios.RadioStation;

import java.util.Comparator;
import java.util.List;

public class RadiosSorter {
    public static final Comparator<RadioStation> byName = Comparator.comparing(RadioStation::getProducer);
    public static Comparator<RadioStation> byChannel = (a, b) -> (a instanceof HandCBRadio & b instanceof HandCBRadio) ?
            Integer.compare(((HandCBRadio)a).getChannel(), ((HandCBRadio)b).getChannel()) : 0;
    public static void sortRadiosByName(List<RadioStation> radioStations){
        radioStations.sort(byName);
    }
    public static void sortRadiosByChannel(List<RadioStation> radioStations){
        radioStations.sort(byChannel);
    }
}

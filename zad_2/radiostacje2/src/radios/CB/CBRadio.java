package radios.CB;

import radios.Modulation;
import radios.RadioStation;

public abstract class CBRadio extends RadioStation {
    protected int channel;

    public CBRadio(String producer, double frequency, Modulation modulation, int channel) {
        super(producer, frequency, modulation);
        this.channel = channel;
    }

    public void setChannelAndFrequency(int channel) {
        this.channel = channel;
        this.frequency = 26.950 + channel * 0.01;
    }

    public int getChannel() {
        return channel;
    }
}

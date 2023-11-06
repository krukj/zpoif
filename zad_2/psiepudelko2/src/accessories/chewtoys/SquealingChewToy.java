package accessories.chewtoys;

import helper.InitHelper;


public class SquealingChewToy extends ChewToy{
    private int frequency;

    public SquealingChewToy() {
        this.frequency = InitHelper.provideRandomFrequencyGenerator();
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "SquealingChewToy{" +
                "frequency=" + frequency +
                ", certificate=" + certificate +
                ", producer='" + producer + '\'' +
                '}';
    }
}

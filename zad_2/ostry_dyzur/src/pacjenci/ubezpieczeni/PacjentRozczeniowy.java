package pacjenci.ubezpieczeni;

//import generator.Generator;
import pacjenci.Pacjent;

public class PacjentRozczeniowy extends Ubezpieczony {
    private StopienRozczeniowosci stopienRozczeniowosci;

    public PacjentRozczeniowy() {
        this.stopienRozczeniowosci = generujStopien();
    }

    public StopienRozczeniowosci getStopienRozczeniowosci() {
        return stopienRozczeniowosci;
    }

    @Override
    public String toString() {
        return "PacjentRozczeniowy{" +
                "stopienRozczeniowosci=" + stopienRozczeniowosci +
                ", id=" + id +
                ", wiek=" + wiek +
                ", problemy=" + problemy +
                '}';
    }
    @FunctionalInterface
    interface GeneratorStopniaRozczeniowosci {
        StopienRozczeniowosci generateDemandingLevel();
    }
    public StopienRozczeniowosci generujStopien(){
        GeneratorStopniaRozczeniowosci generator = () -> {
            if (random.nextDouble() < 0.9) {
                if (random.nextBoolean()) {
                    return StopienRozczeniowosci.SMALL;
                } else {
                    return StopienRozczeniowosci.AVERAGE;
                }
            } else {
                return StopienRozczeniowosci.BIG;
            }
        };
        return generator.generateDemandingLevel();
    }
}

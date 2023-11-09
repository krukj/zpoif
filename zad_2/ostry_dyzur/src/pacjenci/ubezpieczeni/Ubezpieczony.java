package pacjenci.ubezpieczeni;

//import generator.Generator;
import pacjenci.Pacjent;

public abstract class Ubezpieczony extends Pacjent {
    protected int id;

    public Ubezpieczony() {
        this.id = generujID();
    }

    public int getId() {
        return id;
    }
    @FunctionalInterface
    interface GeneratorID {
        int generateInsuranceId();
    }
    private int generujID(){
        GeneratorID generatorID = () -> {
            int x = random.nextInt(10000);
            return x + 10440000;
        };
        return generatorID.generateInsuranceId();
    }

}

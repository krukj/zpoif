package pacjenci;

//import generator.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public abstract class Pacjent {
    protected Random random = new Random();
    protected int wiek;
    protected List<Problem> problemy;

    public Pacjent() {
        this.problemy = generujProblem(random.nextBoolean());
        this.wiek = generujWiek(random.nextInt(100));
    }
    @FunctionalInterface
    public interface Diagnose {
        void diagnoseMe(Pacjent pacjent);
    }
    public void applyDiagnose(Diagnose diagnose) {
        diagnose.diagnoseMe(this);
    }

    public List<Problem> getProblemy() {
        return problemy;
    }

    public int getWiek() {
        return wiek;
    }
    @FunctionalInterface
    interface GeneratorWieku {
        int generateLimitedAge(int limit);
    }
    private int generujWiek(int limit){
        GeneratorWieku generatorWieku = (x) -> random.nextInt(limit + 1);
        return generatorWieku.generateLimitedAge(limit);
    }
    @FunctionalInterface
    interface GeneratorProblemow {
        List<Problem> generateProblem(boolean tick);
    }
    public List<Problem> generujProblem(boolean tick) {
        List<Problem> mozliweProblemy = List.of(Problem.values());
        List<Problem> problemy = new ArrayList<>();
        GeneratorProblemow generatorProblemow = (x) -> {
            if (tick) {
                problemy.add(Problem.POGRYZIENIE_PRZEZ_KLESZCZA);
            }
            problemy.add(mozliweProblemy.get(random.nextInt(mozliweProblemy.size())));
            return problemy;
        };
        return generatorProblemow.generateProblem(tick);

    }

}

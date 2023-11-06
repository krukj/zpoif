package complex;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import static java.lang.Math.*;

public class ComplexFunction {
    public List<Function<Double, Double>> getComplexFunction() {
        return Arrays.asList(
            x -> x * sin(x) * x * x * x,
                x -> cos(sqrt(abs(x))),
                x -> PI * new Random().nextDouble(1, 10)
        );
    }
    public static Function<Double, Double> calculateValue(List<Function<Double, Double>> functions) {
        return x -> functions.stream().mapToDouble(f -> f.apply(x)).sum();
    }
}

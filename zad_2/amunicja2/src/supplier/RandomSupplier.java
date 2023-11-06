package supplier;

import java.util.Random;
import java.util.function.Supplier;

public class RandomSupplier {
    private static final Random random = new Random();
    public static double provideRandomCaliberGenerator() {
        double[] values = {4, 5.56, 7.62, 9, 12.7};
        Supplier<Double> value = () -> values[random.nextInt(values.length)];
        return value.get();
    }
    public static boolean provideRandomSafeGenerator(boolean alwaysUnlocked) {
        Supplier<Boolean> res = () -> false;
        if (random.nextDouble() < 0.95 & !alwaysUnlocked) {
            res = () -> true;
        }
        return res.get();
    }
    public static int provideRandomCO2EmissionGenerator(int a, int b) {
        Supplier<Integer> res = () -> random.nextInt(a, b + 1);
        return res.get();
    }

}

package helper;

import accessories.Accessory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class InitHelper {
    private static final Random random = new Random();
    public static String provideRandomProducerNameGenerator() {
        List<String> names = Arrays.asList("DINGO", "FAFIK", "My pet", "LAPA", "CERBER", "raBIES");
        Supplier<String> value = () -> names.get(random.nextInt(names.size()));
        return value.get();
    }
    public static int provideRandomFrequencyGenerator() {
        List<Integer> freq = Arrays.asList(16, 18, 20, 22, 24);
        Supplier<Integer> value = () -> freq.get(random.nextInt(freq.size()));
        return value.get();
    }
    public static boolean provideRandomAttestationGenerator(boolean alwaysTrue) {
        Supplier<Boolean> res = () -> false;
        if (alwaysTrue) {
            res = () -> true;
        }
        if (res.get()) {
            return res.get();
        } else {
            res = () -> random.nextDouble() < 0.95;
        }
        return res.get();
    }
    public static int provideRandomCaloriesValue(int x, int y){
        Supplier<Integer> res = () -> random.nextInt(x, y + 1);
        return res.get();
    }

}

import media.MassMedia;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        List<MassMedia> media = generator.getMedia();
        for (MassMedia massMedia: media) {
            System.out.println(massMedia);
        }

        Consumer<String> startsWithA = s -> {
            if (s.startsWith("A")) {
                System.out.println(s + " starts with A");
            }
        };
        List<String> strings = Arrays.asList("A", "AA", "bhbc", "db");
        strings.forEach(startsWithA);

        Consumer<String> printCharacters = System.out::println;
        strings.forEach(printCharacters);

        Consumer<String> printReversed = s -> {
            System.out.println(new StringBuilder(s).reverse());
        };
        strings.forEach(printReversed);

        AtomicInteger atomicInteger = new AtomicInteger(0);
        Consumer<String> isNumeric = s -> {
            try {
                int i = Integer.parseInt(s);
                String result = (i % 2 == 0) ? "parzysta" : "Nieparzysta";
                System.out.println(result);
                atomicInteger.addAndGet(i);
                System.out.println("Suma: " + atomicInteger.get());
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        };
        List<Integer> numbers = Arrays.asList(1, 2, 10, 35);
        for (Integer number : numbers) {
            isNumeric.accept(String.valueOf(number));
        }
    }
}
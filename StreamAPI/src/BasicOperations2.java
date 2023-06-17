import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicOperations2 {
    public static void main(String[] args) {
        IntStream.range(1,10)
                .filter(item -> item > 5)
                .forEach(System.out::println);

        Arrays.stream(new int[] {3,9,8,6,4})
                .map(item -> item +10)
                .average()
                .ifPresent(System.out::println);

        int sum = IntStream.range(1,100)
                .sum();
        System.out.println(sum);

        Stream.of("1","5","9","6","2")
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        IntStream.range(1,10)
                .mapToObj(String::valueOf)
                .forEach(System.out::println);

        Stream.of(1,2,3,4,5)
                .mapToDouble(Integer::doubleValue)
                .forEach(System.out::println);

        Stream.of(1.0,2.0,3.0,4.0)
                .mapToInt(Double::intValue)
                .max()
                .ifPresent(System.out::println);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicOperations {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Ordu");
        list.add("Samsun");
        list.add("Sakarya");
        list.add("Sinop");
        list.add("Trabzon");
        list.add("Rize");

        list.stream()
                .filter(item ->item.startsWith("S"))
                .map(String::toUpperCase)
                .sorted(String::compareTo)
                .forEach(System.out::println);

        int[] array = {3,8,9,4,7,3,9,5};
        Arrays.stream(array)
                .filter(item -> item > 4)
                .map(item -> item *3)
                .sorted()
                .forEach(System.out::println);

    }
}
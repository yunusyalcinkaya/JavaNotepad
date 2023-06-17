package methodReferences;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(2.0);
        list.add(4.0);
        list.add(1.0);
        list.add(3.0);

        // * consumer functional interface
        // ? list.forEach(item -> System.out.println(item));
        // * bir üstteki satır ile aynı işi yapar
        list.forEach(System.out::println);

    }
}

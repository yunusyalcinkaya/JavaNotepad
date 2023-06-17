package methodReferences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

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

        System.out.println("example 2");
        // * DoubleBinaryOperator -> functional interface
        DoubleBinaryOperator operator = Math::pow;
        list.forEach(item-> System.out.println(operator.applyAsDouble(item,2)));

        System.out.println("example 3");
        list.forEach(Math::sqrt);
        list.forEach(System.out::println);

    }
}

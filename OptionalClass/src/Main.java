import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<String> obje1 = Optional.empty();
        System.out.println(obje1.isPresent());

        String text = "Hello";
        Optional<String> obje3 = Optional.of(text);
        System.out.println(obje3.isPresent());

        String text2 = "Hello2";
        Optional<String> obje4 = Optional.ofNullable(text2);
        obje4.ifPresent(System.out::println);

        String text3 = null;
        String text4 = Optional.ofNullable(text3).orElseGet(() -> "Hello3");
        System.out.println(text4);

    }
}
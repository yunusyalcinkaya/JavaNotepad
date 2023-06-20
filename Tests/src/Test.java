import java.util.Arrays;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        input = input.trim();// baştaki ve sondaki boşlukları alır
        String[] arr1 = input.split("[ !,?._'@]+");
        System.out.println(arr1.length);
        Arrays.stream(arr1)
                .forEach(System.out::println);



    }
}
public class Factorial {

    private static int factorial(int number) {
        //?  n! = n * n-1 * ... * 2
        if (number < 0) {
            System.out.print("number variable cannot be negative: ");
            return number;
        }
        if (number <= 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    public static void main(String[] args) {

        System.out.println(factorial(6));
        System.out.println(factorial(1));
        System.out.println(factorial(4));
        System.out.println(factorial(-1));
        System.out.println(factorial(2));
    }
}

// * 0 1 1 2 3 5 8 13 ...
public class FibonacciSequence {

    // ? Fibonacci number in the 5th index (first index = 1)
    private static int fibonacci(int index){

        if(index < 1){
            System.out.print("index cannot be less than 1, index= ");
            return index;
        }

        if(index == 1){
            return 0;
        } else if (index == 2) {
            return 1;
        }

        return fibonacci(index -1) + fibonacci(index -2);
    }

    public static void main(String[] args) {

        System.out.println(fibonacci(-2));
        System.out.println("fibonacci 1: "+fibonacci(1));
        System.out.println("fibonacci 3: "+fibonacci(3));
        System.out.println("fibonacci 5: "+fibonacci(5));
        System.out.println("fibonacci 8: "+fibonacci(8));
    }
}

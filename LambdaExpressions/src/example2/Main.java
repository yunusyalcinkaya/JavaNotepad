package example2;

public class Main {
    public static void main(String[] args) {

        MyMath math = (x,y) -> System.out.println(x+y);
        math.operation(20,10);

        MyMath math2 = (x,y) -> System.out.println(x*y);
        math2.operation(5,8);
    }
}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    static void  sample1() {
        String pattern = "ID:1 .+";
        String splitPattern = "( +)";

        String neighborPattern = ".+neighbour.+";

        String s = "ID:1    10 32 45 -1 -11 4";
        System.out.println(s.matches(pattern));
        System.out.println("\n");

        String[] splitted = s.split(splitPattern);

        for(int i=1; i< splitted.length; i++){
            System.out.print(Integer.parseInt(splitted[i]) + " ");
        }
        System.out.println("\n");
        System.out.println("ID:1 neighbour list: 3, 5, 7, 9".matches(neighborPattern));
    }

    public static void main(String[] args) {
        sample1();
        System.out.println(System.lineSeparator());
    }
}
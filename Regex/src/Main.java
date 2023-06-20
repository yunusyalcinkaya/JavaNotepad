import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static void  sample1(){
        String pattern = "[abc]def";

        System.out.println("adef".matches("[abc]def"));
        System.out.println("abdef".matches(pattern));
        System.out.println("cdef".matches(pattern));
        System.out.println("fdef".matches(pattern));
    }

    static void sample2(){
        // ? Does not contain any of the letters a, b, c
        Pattern pattern = Pattern.compile("[^abc]def");
        // ? if regex ="^[abc]def", start with any of the letters a, b, c
        Matcher matcher1 = pattern.matcher("adef");
        Matcher matcher2 = pattern.matcher("abdef");
        Matcher matcher3 = pattern.matcher("cdef");
        Matcher matcher4 = pattern.matcher("fdef");

        System.out.println(matcher1.matches());
        System.out.println(matcher2.matches());
        System.out.println(matcher3.matches());
        System.out.println(matcher4.matches());

        System.out.println(Pattern.matches("[0-9]","5"));
        System.out.println(Pattern.matches("[0-9]","9"));
    }

    static void sample3(){
        Pattern pattern = Pattern.compile("[a-z]",Pattern.CASE_INSENSITIVE);

        System.out.println(pattern.matcher("b").matches());
        System.out.println(pattern.matcher("B").matches());
    }

    public static void main(String[] args) {
        sample1();
        System.out.println(System.lineSeparator());
        sample2();
        System.out.println(System.lineSeparator());
        sample3();
    }
}
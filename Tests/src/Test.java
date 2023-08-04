import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Test {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {

        long maxi=0;
        long mini=0;
        arr.sort(Integer::compareTo);

        for(int i=0; i<4; i++){

            mini += arr.get(i);
            maxi += arr.get(arr.size()-1-i);
        }

        System.out.println(mini + " " + maxi);
    }

    public static void time(String s){

        if((s.endsWith("PM") && !s.startsWith("12")) || (s.endsWith("AM") && s.startsWith("12"))){
            s = String.valueOf((Integer.parseInt(s.substring(0,2)) + 12) % 24) + s.substring(2,s.length()-2);
            if(s.length() != 8){
                s = "0" + s;
            }
            System.out.println(s);
            return;
        }
        s = s.substring(0,s.length()-2);
        System.out.println(s);
    }

    public static void main(String[] args) throws IOException {

        time("12:40:22AM");
    }
}

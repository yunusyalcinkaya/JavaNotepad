import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AddTwoArrayFormOfInteger {

    public static List<Integer> addToArrayForm(int[] num, int k) {

        BigInteger number = BigInteger.ZERO;
        BigInteger sum;
        int length = num.length;
        List<Integer> list = new ArrayList<>();

        for (int i=num.length -1; i>=0; i--) {
            number = number.add(BigInteger.valueOf(10).pow(length-i-1).multiply(BigInteger.valueOf(num[i])));
        }
        sum = number.add(BigInteger.valueOf(k));

        // start
        String stringNumber = sum.toString();
        char[] array = stringNumber.toCharArray();
        for (char item : array) {
            list.add(Integer.parseInt(String.valueOf(item)));
        }
        // end, yorum satırı bu alanın alternatifi

/*        while (sum.compareTo(BigInteger.ONE) >= 0) {
            list.add(sum.mod(BigInteger.valueOf(10)).intValue());
            sum = sum.divide(BigInteger.valueOf(10));
        }
        Collections.reverse(list);*/
        return list;
    }

    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[] {9,9,9,9,9,9,9,9,9,9},1));
        System.out.println(addToArrayForm(new int[] {1,2,0,0},34));

        //https://leetcode.com/problems/add-to-array-form-of-integer/description/
    }
}

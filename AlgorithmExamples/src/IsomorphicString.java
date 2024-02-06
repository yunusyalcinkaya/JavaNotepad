import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        if (arr1.length != arr2.length)
            return false;

        char[] arr3 = new char[t.length()];
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (int i=0; i<arr1.length; i++) {
            char c = arr2[i];
            for (int j=i; j<arr2.length; j++) {
                if (!set2.contains(c) && !set1.contains(arr1[i]) && arr2[j] == c) {
                    arr3[j] = arr1[i];
                }
            }
            set2.add(c);
            set1.add(arr1[i]);
        }
        return String.valueOf(arr1).equals(String.valueOf(arr3));
    }

    public static void main(String[] args) {

        System.out.println(isIsomorphic("egg","add"));
        System.out.println(isIsomorphic("foo","bar"));//false
        System.out.println(isIsomorphic("paper","title"));
        System.out.println(isIsomorphic("egcd","adfd"));//false
        System.out.println(isIsomorphic("baa","cfa"));//false

        // https://leetcode.com/problems/isomorphic-strings/description/
    }
}

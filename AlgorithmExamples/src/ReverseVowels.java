import java.util.*;

/* https://leetcode.com/problems/reverse-vowels-of-a-string/
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */
public class ReverseVowels {

    public static String reverseVowels(String s) {

        char[] arr = s.toCharArray();
        int len = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        TreeMap<Integer,Character> map = new TreeMap<>();
        for(int i=0; i<len; i++){
            if(vowels.contains(arr[i])){
                map.put(i,arr[i]);
                list.add(i);
            }
        }
        int i = list.size() -1;
        for(int item : map.keySet()){
            arr[list.get(i)] = map.get(item);
            i--;
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {

        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("Sore was I ere I saw Eros."));//"SorE was I ere I saw eros."
    }
}

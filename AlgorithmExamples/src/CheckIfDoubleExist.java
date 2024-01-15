import java.util.HashSet;
import java.util.Set;

public class CheckIfDoubleExist {

    public static boolean checkIfExist(int[] arr) {

/*        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j< arr.length; j++) {
                if (arr[i] == arr[j] *2 || arr[i] *2 == arr[j])
                    return true;
            }
        }*/

        // start
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<arr.length; i++) {
            if (!set.add(arr[i]) && arr[i] == 0)
                return true;
        }
        for (int i=0; i<arr.length-1; i++) {

                if (arr[i] != 0 &&
                        (set.contains(arr[i] *2) ||
                        (arr[i] %2 == 0 &&  set.contains(arr[i] /2)))
                )
                    return true;

        }
        // end , yorum satırının alternatifi

        return false;
    }

    public static void main(String[] args) {

        System.out.println(checkIfExist(new int[] {-2,0,10,-19,4,6,-8}));

        // https://leetcode.com/problems/check-if-n-and-its-double-exist/description/
    }
}

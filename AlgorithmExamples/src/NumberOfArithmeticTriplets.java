import java.util.HashSet;
import java.util.Set;

public class NumberOfArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {

        Set<Integer> set = new HashSet<>();

        for(int item : nums){
            set.add(item);
        }

        int counter = 0;

        for(int item : nums){
            if(set.contains(item + diff) && set.contains(item + 2*diff))
                counter++;
        }


        return counter;
    }

    public static void main(String[] args) {
// https://leetcode.com/problems/number-of-arithmetic-triplets/description/
    }
}

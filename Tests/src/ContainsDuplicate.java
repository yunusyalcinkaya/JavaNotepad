import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

    public static boolean containsDuplicate1(int[] nums){

        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);

        return set.size() != nums.length;
    }

    static boolean containsDuplicate2(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int item : nums){
            set.add(item);
        }
        return set.size() != nums.length;
    }

    static boolean containsDuplicate3(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        Arrays.sort(nums);

        int prevItem = nums[0];
        for(int i=1; i< nums.length; i++){
            if(prevItem == nums[i]){
                return true;
            }
            prevItem = nums[i];
        }
        return false;

    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate1(nums));
        System.out.println(containsDuplicate2(nums));
        System.out.println(containsDuplicate3(nums));


    }
}
import java.util.Arrays;
import java.util.HashMap;

/*
https://leetcode.com/problems/majority-element/

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109

Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int maxValue = 0;
        int response = 110;

        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > maxValue){
                maxValue = map.get(key);
                response = key;
            }
        }
        
        return response;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}

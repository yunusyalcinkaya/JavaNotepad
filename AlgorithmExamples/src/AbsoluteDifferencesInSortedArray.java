import java.util.Arrays;

public class AbsoluteDifferencesInSortedArray {
/* https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

Example 1:

Input: nums = [2,3,5]
Output: [4,3,5]
Explanation: Assuming the arrays are 0-indexed, then
result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4,
result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3,
result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5.

Example 2:

Input: nums = [1,4,6,8,10]
Output: [24,15,13,15,21]
 */
    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int[] response = new int[nums.length];

        for(int i =0; i< nums.length; i++){
            int sum=0;
            for (int num : nums) {
                sum += Math.abs(nums[i] - num);
            }
            response[i] = sum;
        }
        return response;
    }

    public static int[] getSumAbsoluteDifferences2(int[] nums) {
        int[] response = new int[nums.length];
        int left = 0;
        for(int i =0; i< nums.length; i++){
            int sum=0;
            for(int j=i; j< nums.length; j++){
                sum += Math.abs(nums[i] - nums[j]);
            }
            sum += Math.abs(left -( i * nums[i]));
            response[i] = sum;
            left += nums[i];
        }
        return response;
    }

    public static int[] getSumAbsoluteDifferences3(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int[] forward = new int[len];
        int[] reverse = new int[len+1];
        int[] response = new int[len];
        reverse[len] = 0;

        for(int i=0; i< nums.length; i++){
            forward[i] = nums[i] + left;
            reverse[len-1-i] = nums[len-1-i] + right;
            left = forward[i];
            right = reverse[len-1-i];
        }

        for(int i =0; i< len; i++){
            response[i] = (i+1)*nums[i] - forward[i] +  reverse[i+1] - (len -i-1)*nums[i];
        }
        return response;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSumAbsoluteDifferences3(new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(getSumAbsoluteDifferences3(new int[]{1,4,6,8,10})));
    }
}

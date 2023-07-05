import java.util.Arrays;

public class DistanceValueBetweenTwoArray {

    public static int findTheDistanceValue1(int[] arr1, int[] arr2, int d) {

/*        int diff,counter=0;
        for (int item1 : arr1) {
            for (int item2 : arr2) {
                diff = Math.abs(item1 - item2);
                if (diff <= d) {
                    counter++;
                    break;
                }
            }
        }
        return arr1.length - counter; */
        return arr1.length - (int)Arrays.stream(arr1)
                .filter(item -> Arrays.stream(arr2).anyMatch(item2 -> Math.abs(item - item2) <= d)).count();
    }


    public static void main(String[] args) {

        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        int[] arr3 = {1,4,2,3};
        int[] arr4 = {-4,-3,6,10,20,30};
        int[] arr5 = {2,1,100,3};
        int[] arr6 = {-5,-2,10,-3,7};

        System.out.println(findTheDistanceValue1(arr1,arr2,2)); // expected: 2
        System.out.println(findTheDistanceValue1(arr3,arr4,3)); // expected: 2
        System.out.println(findTheDistanceValue1(arr5,arr6,6)); // expected: 1


    }
}

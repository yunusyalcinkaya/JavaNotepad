import java.util.Arrays;

public class MinimumCost {
    public static int minimumCost(int[] cost) {

        Arrays.sort(cost);

        int n = cost.length;
        int alpha= n%3;

        int total=0;
        for(int i = n-1; i >=0; i--){
            if(alpha != i%3){
                total+= cost[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {

        int[] array = {5,5, 12, 23,4, 6,7,8,94, 11,66};
        System.out.println( minimumCost(array));


    }
}

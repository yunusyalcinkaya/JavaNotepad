public class MinimumCost2 {
    public static int minimumCost(int[] cost) {

        cost = sort(cost);
        int costLen = cost.length;
        int total=0;
        for(int i=0; i< costLen; i++){
            if(i%3 != 2){
                total += cost[i];
            }
        }

        return total;

    }

    public static int[] sort(int[] cost){

        int costLen = cost.length;
        for(int i=0; i< costLen;i++){
            for(int j=0; j< costLen; j++){

                if(cost[i] > cost[j]){
                    int temp= cost[i];
                    cost[i] = cost[j];
                    cost[j] = temp;
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {


        int[] array = {5,5, 12, 23,4, 6,7,8,94, 11,66};
        System.out.println( minimumCost(array));


    }
}

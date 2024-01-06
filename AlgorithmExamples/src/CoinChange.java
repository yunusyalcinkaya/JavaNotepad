import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {

        // <currentAmount,numCoins>
        ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<>();
        int size = coins.length;
        int numCoins = 0;
        int currentAmount = 0;

        if(amount == 0)
            return 0;

        for(int i=size-1; i>=0; i--){
            currentAmount = 0;
            numCoins = 0;
            while(currentAmount <= amount - coins[i]){
                currentAmount += coins[i];
                numCoins++;
                if(map.get(amount - currentAmount) != null && map.get(amount) == null
                        || (map.get(amount - currentAmount) != null && map.get(amount) != null && map.get(amount) > numCoins + map.get(amount - currentAmount)))
                    map.put(amount, numCoins + map.get(amount - currentAmount));

                Set<Integer> keySet = map.keySet();
                for(int item : keySet){
                    if((item + currentAmount <= amount && map.get(item + currentAmount) == null
                            || item + currentAmount <= amount && map.get(item + currentAmount) != null && map.get(item + currentAmount) > numCoins + map.get(item)))
                        map.put(item + currentAmount, numCoins + map.get(item));
                }

                if(map.get(currentAmount) == null || map.get(currentAmount) > numCoins)
                    map.put(currentAmount,numCoins);
            }
        }
        if(map.get(amount) != null)
            return map.get(amount);

        return -1;
    }


    public static void main(String[] args) {

        System.out.println(coinChange(new int[] {1,2,5}, 11));
        System.out.println(coinChange(new int[] {1,2,5,10}, 18));
        System.out.println(coinChange(new int[] {493,416,144,164,314,25}, 5607));
    }
    // https://leetcode.com/problems/coin-change/
}

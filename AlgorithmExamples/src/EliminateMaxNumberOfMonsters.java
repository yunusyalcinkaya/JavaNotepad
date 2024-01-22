import java.util.Arrays;

public class EliminateMaxNumberOfMonsters {

    public static int eliminateMaximum(int[] dist, int[] speed) {

        int numMonsters = dist.length;
        double[] monsterArrivalDelay = new double[numMonsters];
        int counter = 0;

        for (int i=0; i<numMonsters; i++) {
            monsterArrivalDelay[i] = (double) dist[i] / speed[i];
        }
        Arrays.sort(monsterArrivalDelay);

        for (int i=0; i< numMonsters; i++) {

            if (monsterArrivalDelay[i] <= i)
                return counter;
            counter++;
        }

        return counter;
    }

    public static void main(String[] args) {

        System.out.println(eliminateMaximum(new int[] {1,3,4},new int[]{1,1,1}));
        System.out.println(eliminateMaximum(new int[] {1,1,2,3},new int[]{1,1,1,1}));
        System.out.println(eliminateMaximum(new int[] {3,2,4},new int[]{5,3,2}));

        // https://leetcode.com/problems/eliminate-maximum-number-of-monsters/description/
    }
}

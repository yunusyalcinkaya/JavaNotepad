import java.util.Collections;
import java.util.List;

public class BetweenTwoSets {

    public int getTotalX(List<Integer> a, List<Integer> b) {

        Collections.sort(a);
        Collections.sort(b);

        int sizeA = a.size();
        int counter = 0;

        for(int i = b.get(0); i >= a.get(sizeA-1); i--){
            if(isArrayItemsFactor(a,i) && isFactorForArrayItems(b,i))
                counter++;
        }

        return counter;
    }

    private boolean isArrayItemsFactor(List<Integer> list, int factor){
        for(int item : list){
            if(factor % item != 0)
                return false;
        }
        return true;
    }

    private boolean isFactorForArrayItems(List<Integer> list, int factor){
        for(int item : list){
            if(item % factor != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
// https://www.hackerrank.com/challenges/between-two-sets/problem?isFullScreen=true
    }
}

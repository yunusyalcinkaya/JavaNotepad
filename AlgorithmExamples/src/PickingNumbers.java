import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PickingNumbers {

    public static int pickingNumbers(List<Integer> a) {

        Collections.sort(a);
        int size = a.size();
        int counter = 1;
        int max = 0;
        boolean flag = true;


        Map<Integer,Integer> map = new HashMap<>();
        int index = 1;

        while (index < size) {
            if (!Objects.equals(a.get(index), a.get(index - 1))) {

                map.put(a.get(index),index);
                if (a.get(index) - a.get(index-1) < 2) {

                    if (flag) {
                        index++;
                        flag = false;
                        counter++;
                    }
                    else {
                        index = map.get(a.get(index-1)) != null ? map.get(a.get(index-1)) +1 : index+1;
                        max = Math.max(counter,max);
                        counter = 1;
                        flag = true;
                    }
                }
                else {
                    max = Math.max(counter, max);
                    counter = 1;
                    flag = true;
                    index++;
                }
            }
            else {
                counter++;
                index++;
            }
        }

        return Math.max(counter,max);
    }

    public static void main(String[] args) {

        System.out.println(pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1)));
        System.out.println(pickingNumbers(Arrays.asList(4, 2, 3, 4, 4, 9, 98, 98, 3, 3, 3, 4, 2, 98, 1, 98, 98, 1, 1 ,4 ,98 ,2 ,98 ,3 ,9 ,9 ,3 ,1 ,4 ,1 ,98 ,9 ,9 ,2 ,9 ,4 ,2 ,2 ,9 ,98 ,4 ,98 ,1 ,3 ,4 ,9 ,1 ,98 ,98 ,4 ,2 ,3 ,98 ,98 ,1 ,99, 9 ,98, 98, 3 ,98 ,98, 4 ,98 ,2 ,98, 4, 2, 1, 1, 9, 2, 4)));

        // https://www.hackerrank.com/challenges/picking-numbers/problem?isFullScreen=true
    }
}

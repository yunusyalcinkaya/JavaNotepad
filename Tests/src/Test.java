import java.util.*;

public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int n = in.nextInt();
        int m = in.nextInt();
        Set<Integer> set = new HashSet<>();
        int a = 0;
        int num;
        int setSize=0;
        int removed;
        for (int i = 0; i < n; i++) {
            num = in.nextInt();
            deque.addLast(num);
            set.add(num);
            if (i >= m - 1) {
                setSize = set.size();
                removed = deque.removeFirst();
                if(!deque.contains(removed)){
                    set.remove(removed);
                }
                if (setSize > a) {
                    a = setSize;
                }
            }
        }
        System.out.println(a);
    }
}

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArrangeRedBalls {

   /*
   ? "WWRRWWR" şeklinde white ve red renklerini temsil eden String veriliyor
   ? tek seferde iki adet bitişik harfin yerini değiştirebilirsin
   ? R harflerini minimum kaç seferde yanyana getirebilirsin
    */

    public static int solution(String s){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'R') list.add(i);
        }
        int size = list.size();
        int average = size % 2 == 0
                ? (list.get((int) size / 2) + (list.get((int) size / 2 -1))) / 2
                : list.get((int) size / 2);

        int sum = list.stream()
                .map(item -> Math.abs(item - average) - 1)
                .mapToInt(Integer::intValue)
                .sum() + 1;
        return size % 2==0 && size > 2 ? sum -1 : sum;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(solution("WWR")); //! 0
        System.out.println(solution("WWRWWWRWR")); //! 4
        System.out.println(solution("WRRWWR")); //! 2
        System.out.println(solution("RWWRR")); //! 2
        System.out.println(solution("RWWWWR")); //! 4
        System.out.println(solution("RWRWR")); //! 2
        System.out.println(solution("WRWRR")); //! 1
        System.out.println(solution("WRWWRR")); //! 2
        System.out.println(solution("RRWWRW")); //! 2
        System.out.println(solution("RWWWWWWWRR")); //! 7
        System.out.println(solution("WRRWWR")); //! 2
        System.out.println(solution("WWRWWWRWR")); //! 4
        System.out.println(solution("RWWRWWWRWR")); //! 9
        System.out.println(solution("WRWWRRWWR")); //! 4
        System.out.println(solution("RWWRWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWRR")); //! 84
    }
}

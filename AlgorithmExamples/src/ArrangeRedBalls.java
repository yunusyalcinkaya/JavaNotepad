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
        // index list of red balls
        List<Integer> indexList = new ArrayList<>();
        // add indexes of red balls to indexList
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'R') indexList.add(i);
        }

        int sizeOfIndexList = indexList.size();
        int halfSizeOfIndexList = (int)sizeOfIndexList /2;
        if(sizeOfIndexList == 0 || sizeOfIndexList == s.length()) return 0;
            // 2 6 8
        int midOfIndexList = sizeOfIndexList % 2 == 0
                ? (indexList.get(halfSizeOfIndexList) + (indexList.get(halfSizeOfIndexList -1))) / 2
                : indexList.get(halfSizeOfIndexList);

        int sum = indexList.stream()
                .map(item -> Math.abs(item - midOfIndexList))
                .mapToInt(Integer::intValue)
                .sum();

        sum -= sizeOfIndexList % 2 == 0
                ? Math.pow(halfSizeOfIndexList,2) // n*(n+1)/2 + n*(n-1)/2 = n^2
                : halfSizeOfIndexList * (halfSizeOfIndexList +1);

        return sum;
    }

    /*
            R R R R W R  -> 1
            0 1 2 3   5 -> 11, 10 çıkarmam lazım, n=4, n*(n+1)/2 = 10
              0 0 0   1
     */

    public static void main(String[] args) throws IOException {

        System.out.println("0  -> " + solution("W"));
        System.out.println("0  -> " + solution("WWWWWWW"));
        System.out.println("0  -> " + solution("R"));
        System.out.println("0  -> " + solution("RRRRRRR"));
        System.out.println("0  -> " + solution("WWR"));
        System.out.println("4  -> " + solution("WWRWWWRWR"));
        System.out.println("2  -> " + solution("WRRWWR"));
        System.out.println("2  -> " + solution("RWWRR"));
        System.out.println("4  -> " + solution("RWWWWR"));
        System.out.println("2  -> " + solution("WRWWRR"));
        System.out.println("2  -> " + solution("RRWWRW"));
        System.out.println("9  -> " + solution("RWWRWWWRWR"));
        System.out.println("4  -> " + solution("WRWWRRWWR"));
        System.out.println("84 -> " + solution("RWWRWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWRR"));
        System.out.println("3  -> " + solution("WRWWRRRWR"));

    }
}

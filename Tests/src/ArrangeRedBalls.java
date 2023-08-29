import java.io.IOException;

public class ArrangeRedBalls {

   /*
   ? "WWRRWWR" şeklinde white ve red renklerini temsil eden String veriliyor
   ? tek seferde iki adet bitişik harfin yerini değiştirebiliyorsun
   ? R harflerini minimum kaç seferde yanyana getirebilirsin
    */

    public static int solution(String s){

        char[] arr = s.toCharArray();
        int totalIndex=0;
        int numberRed=0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == 'R'){
                totalIndex += i;
                numberRed++;
            }
        }

        int avg = (int)(totalIndex/numberRed);
        int numSwap =0;
        int prev =0;

        while(true){
            prev = numSwap;
            for(int i=0; i<arr.length -1; i++){
                if(arr[i]=='R' && arr[i+1] == 'W' && i<avg){
                    arr[i] = 'W';
                    arr[i+1] = 'R';
                    numSwap++;
                }
                else if(arr[i]=='W' && arr[i+1] == 'R' && i>=avg){
                    arr[i] = 'R';
                    arr[i+1] = 'W';
                    numSwap++;
                }
            }
            if(numSwap==prev) break;
        }
        return numSwap;
    }

    public static void main(String[] args) throws IOException {

        String s = "WWRWWWRWR";
        System.out.println(solution(s));

    }
}

import java.util.Arrays;

public class CaesarCipher {
    /*
    ? Bir string verilecek. İçindeki harfleri k sonraki harfler ile değiştir
    ? Özel karakterler aynı kalsın. Yeni string'i döndür
     */
    //  https://www.hackerrank.com/challenges/caesar-cipher-1/problem?isFullScreen=true
    // * A-Z -> 65-90, a-z -> 97-122

    public static String caesarCipher(String s, int k){

        char[] arr = s.toCharArray();

        for(int i=0; i<arr.length; i++){
            if(((int)arr[i] >= 65 && (int)arr[i] <= 90)){
                if((int)arr[i] +(k%26) >90){
                    arr[i] = (char)((((int)arr[i] +(k%26)) %91) +65);
                }
                else arr[i] = (char)((int)arr[i] +(k%26));
            }
            else if ((int)arr[i] >= 97 && (int)arr[i] <= 122) {
                if((int)arr[i] +(k%26) >122){
                    arr[i] = (char)((((int)arr[i] +(k%26)) %123) +97);
                }
                else arr[i] = (char)((int)arr[i] +(k%26));
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(caesarCipher("abc.,-",2));
        System.out.println(caesarCipher("abC.,-",3));
        System.out.println(caesarCipher("xyz.,-",4));
    }
}

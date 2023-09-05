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
        k %= 26;
        for(int i=0; i<arr.length; i++){
            if(((int)arr[i] >= 65 && (int)arr[i] <= 90)){
                if((int)arr[i] + k >90){
                    arr[i] = (char)((((int)arr[i] +k) %91) +65);
                }
                else arr[i] = (char)((int)arr[i] +k);
            }
            else if ((int)arr[i] >= 97 && (int)arr[i] <= 122) {
                if((int)arr[i] +k >122){
                    arr[i] = (char)((((int)arr[i] +k) %123) +97);
                }
                else arr[i] = (char)((int)arr[i] +k);
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

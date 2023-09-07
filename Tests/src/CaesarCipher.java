import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class CaesarCipher {
    /*
    ? Bir string verilecek. İçindeki harfleri k sonraki harfler ile değiştir
    ? Özel karakterler aynı kalsın. Yeni string'i döndür
     */
    //  https://www.hackerrank.com/challenges/caesar-cipher-1/problem?isFullScreen=true

    private static String caesarCipher2(String s, int k){

        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String upperAlphabet = lowerAlphabet.toUpperCase();

        k %= 26;
        char[] array = s.toCharArray();

        int index = 0;
        for(int i=0; i<array.length; i++){

            array[i] = lowerAlphabet.indexOf(array[i]) != -1
                    ? lowerAlphabet.charAt((lowerAlphabet.indexOf(array[i]) +k) %26)
                    : array[i];

            array[i] = upperAlphabet.indexOf(array[i]) != -1
                    ? upperAlphabet.charAt((upperAlphabet.indexOf(array[i]) +k) %26)
                    : array[i];
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        System.out.println(caesarCipher2("abc.,-",2));
        System.out.println(caesarCipher2("abC.,-",3));
        System.out.println(caesarCipher2("xyz.,-",4));
    }
}

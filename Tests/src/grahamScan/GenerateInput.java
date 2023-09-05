package grahamScan;
/*
 * Size verilen bir .txt file aşağıdaki formatta olacak şekilde size
 * verildiğinde bu noktalar kümesi içerisinde birbirine en uzak olan 2
 * noktayı ve aralarındaki uzaklığı bastıracak bir program yazmanızı
 * istiyorum. Önce sizin aklınıza gelen çözüm yönteminiz ile bir program
 * geliştirin ve tamamlayın. Ardından CONVEX HULL ALGORITHM için araştırma
 * yapın ve bu algoritma ile yeni bir program yazın

 * NOT: Her iki uygulama da aynı .txt file'dan okuyacak şekilde programlansın
 * ki birlikte deneyebilelim 😊

 * - File Formatı:
 * x1 y1
 * x2 y2
 * x3 y3
 * x4 y4

 * - Örnek File:
 * 5 10
 * 3 5
 * 6 12
 * 9 20
 */

 /*
  * iki nokta arasındaki uzaklık = |AB| = ( (x2 - x1)^2 + (y2 - y1)^2 )sqrt
  * karekök metodu: Math.sqrt()
  * mutlak değer metodu: Math.abs()
  * üs alma : Math.pow(a,b)
*/

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInput {
    public static void main(String[] args) throws IOException {

        Random random = new Random();
        FileWriter writer = new FileWriter("Tests/src/grahamScan/test.txt",false);

        for(int i =1 ; i <= 1000; i++){

            double number = (double)((int)(random.nextDouble(-1000,1000)*100))/100;
            if(i%2 == 1)
                writer.write(number + " ");
            else
                writer.write(number + "\n");
        }
        writer.close();
    }
}


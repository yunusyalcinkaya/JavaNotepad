import java.math.BigInteger;

public class ClimbingStairs {
    /* https://leetcode.com/problems/climbing-stairs/
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Constraint : 1<= n <= 45

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
     */


    /* tekrarlı permütasyon
            permütasyon = sıralama
            1'ler ve 2'ler kaç farklı şekilde sıralanır sorusunun cevabını arıyoruz
            tekrar eden 1'lerin ve 2'lerin sayısının faktöriyelini paydaya yaz

            n! / (a! * b!) -> n: adım sayısı, a: 1'lerin sayısı, b: 2'lerin sayısı
     */
    public static long climbStairs(long n) {
        long numberOfOne = n;
        long numberOfTwo = 0;
        long stepCount = (long)Math.ceil((double) n /2);
        int result = 0;
        for(long i=n; i>=stepCount; i--){
            result += (factorial(i).divide
                    (factorial(numberOfOne).multiply(factorial(numberOfTwo))))
                    .intValue();
            numberOfTwo += 1;
            numberOfOne -= 2;
        }
        return result;
    }

    public static BigInteger factorial(long n){
        BigInteger response = BigInteger.ONE;
        for(int i=1; i<=n; i++){
            response = response.multiply(BigInteger.valueOf(i));
        }
        return response;
    }

    public static void main(String[] args) {
        System.out.println("13" + climbStairs(6));
        System.out.println("8" + climbStairs(5));
        System.out.println("5" + climbStairs(4));
        System.out.println("3" + climbStairs(3));
        System.out.println("2" + climbStairs(2));
        System.out.println("1" + climbStairs(1));
        System.out.println("14930352" + climbStairs(35));
    }
}

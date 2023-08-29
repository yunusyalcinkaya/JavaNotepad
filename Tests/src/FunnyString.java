public class FunnyString {
    // https://www.hackerrank.com/challenges/funny-string/problem?isFullScreen=true
    /*
    ? Verilen String'deki her karakterin ascii karşılığını al
    ? İkişerli olarak ascii kodlarının mutlak farklarını al
    ? Bu mutlak farklar baştan ve sondan yazıldığında aynı ise funny
     */

    public static String funnyString(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        boolean flag = true;

        for(int i=0; i<(int)(len/2); i++){
            if( (Math.abs((int)arr[i] - (int)arr[i+1])) !=  (Math.abs((int)arr[len-i-1] - (int)arr[len-i-2]))){
                flag = false;
                break;
            }
        }
        return flag ? "Funny" : "Not Funny";
    }

    public static void main(String[] args) {

        System.out.println(funnyString("acxz"));
        System.out.println(funnyString("bcxz"));

    }
}

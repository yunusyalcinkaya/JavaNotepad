import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-1d-array/problem?isFullScreen=true
public class GameOn1DArray {

    public static void start() throws Exception{
        String path1 = "R:\\raw-data.txt";
        String path2 = "R:\\test-expected.txt";

        File rawDataFile = new File(path1);
        File expectedFile = new File(path2);

        Scanner rawDataScanner = new Scanner(rawDataFile);
        Scanner expectedScanner = new Scanner(expectedFile);

        int num = rawDataScanner.nextInt();
        int dataSize;
        int leap;
        int[] arr;
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> expected = new ArrayList<>();
        for(int i=0; i<num; i++){
            expected.add(expectedScanner.nextLine().trim());
        }
        for(int i=0; i<num; i++){
            dataSize = rawDataScanner.nextInt();
            leap = rawDataScanner.nextInt();
            arr = new int[dataSize];
            for(int j=0; j< arr.length; j++){
                arr[j] = rawDataScanner.nextInt();
            }
            result.add(canWin(leap, arr) ? "YES" : "NO");
        }
        System.out.println(compare(result,expected,num));

    }

    public static String compare(ArrayList<String> result, ArrayList<String> expected, int len){
        for(int i=0; i<len; i++){
            if(!result.get(i).equals(expected.get(i))){
                return "wrong: " + i + ", expected: " + expected.get(i) + ", result: " + result.get(i);
            }
        }
        return "success";
    }

    public static boolean canWin(int leap, int[] game) {

        int location = 0;
        boolean flag = true;
        int backStep = 0;
        int forwardOneStep = 0;
        int step = 1;
        while (step < game.length){

            if(location + leap >= game.length || location == game.length -1)
                return  true;

            if (game[location+1] == 0 && flag){
                location++;
                forwardOneStep++;
            }

            else if(game[location+leap] == 0){
                location += leap;
                flag = true;
                backStep = 0;
                forwardOneStep = 1;
            }


            else if (backStep == leap)
                return false;

            else if (location > 0 && game[location-forwardOneStep] == 0){
                location -= forwardOneStep;
                forwardOneStep = 1;
                flag = false;
                backStep += forwardOneStep;
            }
             else return false;
             step++;
        }
        return false;
    }

    public static void main(String[] args) {

/*        System.out.println(canWin(3,new int[]{0,0,0,0,0}));// ture
        System.out.println(canWin(5,new int[]{0,0,0,1,1,1}));// true
        System.out.println(canWin(5,new int[]{0,0,0,1,1,1}));// true
        System.out.println(canWin(3,new int[]{0,0,1,1,1,0}));// false
        System.out.println(canWin(1,new int[]{0,1,0}));// false
        System.out.println(canWin(2,new int[]{0,1,0,1,0,1}));// true
        System.out.println(canWin(6,new int[]{0,0,1,1,0,0,1,1,0,0}));// false
        System.out.println(canWin(3,new int[]{0,0,1,1,0,0,1,1,0,0}));// true
        System.out.println(canWin(4,new int[]{0,1,1,0,0,1,1,0,1}));// true
        System.out.println(canWin(5,new int[]{0,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,1,0,0,1,0,1,1,0,0,1,0,0,0,1,1,0,1,1,0,1,0,1,1,0,0,1,0,0,0,1,0,0,1,0,1,0,1,1,0,1,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0,1}));// true
    */
        try {
            start();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

//        System.out.println(canWin(14,new int[]{0,0,0,0,0,1,0,1,1,1,1,0,1,0,1,0,0,1,0,0,0,1,0,1,0,0,0,0,1,1,0,0,1,0,0,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,1,1,0,0,1,1,1,0,0,0,0,1,0,0,1,1,1,0,0,1,1,1,1,1,1,1,1,0,1,1,0,0,0}));
    }
}

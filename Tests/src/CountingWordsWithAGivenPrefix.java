import java.util.Arrays;

public class CountingWordsWithAGivenPrefix {
    public static int prefixCount(String[] words, String pref) {

        int counter = 0;
        for (String word : words) {
            if(pref.length() > word.length()){
                continue;
            }
            String s = word.substring(0, pref.length());
            if(pref.equals(s)){
                counter ++;
            }
        }
        return counter;

//        int a = (int) Arrays.stream(words)
//                .filter(item -> item.length()>=pref.length() && item.substring(0,pref.length()).equals(pref))
//                .count();
    }

    public static void main(String[] args) {

    }
}

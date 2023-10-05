public class LongestCommonPrefix {
    /*
    * Verilen String'lerden en uzun ortak prefix'i döndür
    * https://leetcode.com/problems/longest-common-prefix/description/
     */
    public static String longestCommonPrefix(String[] strs) {

        String response = strs[0];
        int len = 0;
        for(String item : strs){
            if("".equals(item))
                return "";

            len = item.length();
            for(int i =0; i< len; i++){
                try{
                    if(response.charAt(i) != item.charAt(i)){
                        response = response.substring(0,i);
                        break;
                    }
                }catch (StringIndexOutOfBoundsException e){
                    break;
                }
                if(i >= len -1)
                    response = item;
            }
        }
        return response;
    }
    public static void main(String[] args) {

        String[] s = {"flower","flow","flight","fight"};
        String[] s2 = {"flower","flow","flight"};
        String[] s4 = {"flow","flower"};
        String[] s5 = {"flower","flow"};
        String[] s3 = {"ab","a"};
        String[] s6 = {"ab","a",""};
        System.out.println(longestCommonPrefix(s)); // f
        System.out.println(longestCommonPrefix(s2)); // fl
        System.out.println(longestCommonPrefix(s3)); // a
        System.out.println(longestCommonPrefix(s4)); // flow
        System.out.println(longestCommonPrefix(s5)); // flow
        System.out.println(longestCommonPrefix(s6)); //
    }
}

public class CharacterBits {
    public static boolean isOneBitCharacter(int[] bits) {

        int prevIndex = 0;
        int index = 0;
        int bitsLen = bits.length;
        while(index < bitsLen){

            prevIndex = index;

            if(bits[index] == 0)
                index++;
            else
                index += 2;
        }
        return (index - prevIndex) == 1;
    }

    public static void main(String[] args) {
        int[] array1 = {1,0,0};
        int[] array2 = {1,1,1,0};
        int[] array3 = {1,1,1,0,0};

        System.out.println(isOneBitCharacter(array1));
        System.out.println(isOneBitCharacter(array2));
        System.out.println(isOneBitCharacter(array3));
    }
}

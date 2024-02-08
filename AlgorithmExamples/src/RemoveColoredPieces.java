public class RemoveColoredPieces {

    public static boolean winnerOfGame(String colors) {

        int totalA = 0;
        int totalB = 0;
        int counterA = 0;
        int counterB = 0;

        for (int i=0; i<colors.length(); i++) {
            if (colors.charAt(i) == 'A') {
                counterA++;
                counterB = 0;
                if(counterA >= 3)
                    totalA++;
            }
            else {
                counterB++;
                counterA = 0;
                if (counterB >= 3)
                    totalB++;
            }
        }

        return totalA > totalB;
    }

    public static void main(String[] args) {
        // https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/description/
    }
}

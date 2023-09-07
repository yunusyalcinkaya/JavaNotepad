public class PronunciationOfNumbers {
    public static String getLastThreeDigits(int number){

        String[] decimal = {"","on","yirmi", "otuz", "kirk", "elli", "altmis",
                "yetmis", "seksen", "doksan"};
        String[] numeral = {"","bir", "iki", "üc", "dort", "bes", "alti", "yedi", "sekiz","dokuz"};

        String text = "";

        if(number>0){
            text = numeral[number%10];
            number /= 10;
        }
        if(number > 0){
            text = decimal[number%10] + " " + text;
            number /= 10;
        }// 103  1   üç
        if(number>1){
            text = numeral[number%10] + " yüz " + text;
        }
        else if(number>0){
            text ="yüz " + text;
        }

        return text;
    }

    public static String end(int number){

        String text = "";

        if(number == 0){
            return "sifir";
        }

        if(number<1000){
            return getLastThreeDigits(number);
        }
        text = getLastThreeDigits(number%1000);
        number /= 1000;

        if(number>1){
            if(number%1000!=0){
                text = getLastThreeDigits(number%1000) + " bin " + text;
            }
            number /= 1000;
        }
        else if(number>0){
            text = "bin " + text;
            number /= 1000;
        }

        if(number > 0){
            text = getLastThreeDigits(number %1000) + " milyon " + text;
            number /= 1000;
        }

        if(number > 0){
            text = getLastThreeDigits(number %1000) + " milyar" + text;
            number /= 1000;
        }

        return text;
    }

    public static void main(String[] args) {

        System.out.println(end(2000));
        System.out.println(end(123000));
        System.out.println(end(1453));
        System.out.println(end(1919));
        System.out.println(end(999999));
        System.out.println(end(1000));
        System.out.println(end(321000100));
        System.out.println(end(32240001));
        System.out.println(end(32000));
        System.out.println(end(100000));
        System.out.println(end(201020000));
        System.out.println(end(32000100));
    }
}

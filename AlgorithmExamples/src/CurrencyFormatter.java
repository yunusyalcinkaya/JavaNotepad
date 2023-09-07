import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
    public static void main(String[] args) {

        // Locale içinde tanımlı olan para birimleri
        NumberFormat nfChina = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat nfUD= NumberFormat.getCurrencyInstance(Locale.UK);
        NumberFormat nfUS= NumberFormat.getCurrencyInstance(Locale.US);

        // India, Local içinde hazır tanımlı değil
        Locale indiLocale = new Locale("en", "IN");
        NumberFormat nfIndia = NumberFormat.getCurrencyInstance(indiLocale);


        System.out.println("China: "+nfChina.format(12324.134));
        System.out.println("UD: "+nfUD.format(12324.134));
        System.out.println("US: "+nfUS.format(12324.134));
        System.out.println("India: "+nfIndia.format(12324.134));


    }
}

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocalDateDriver {
    public static void main(String[] args) {

        LocalDate date1 = LocalDate.now();
        System.out.println("date1: " + date1);

        LocalDate date2 = LocalDate.of(1998,9,22);
        System.out.println("date2: " + date2);

        LocalDate date3 = LocalDate.parse("2020-02-22");
        System.out.println("date3: " + date3);
        // * next day
        System.out.println("next day: "+date3.plus(1, ChronoUnit.DAYS));
        // * last month
        System.out.println("last month: "+date3.minus(1,ChronoUnit.MONTHS));
        System.out.println("day of week: "+date3.getDayOfWeek());
        System.out.println("cuurent day of week: " + date1.getDayOfWeek());
        System.out.println("cuurent day of month: " + date1.getDayOfMonth());
        System.out.println("cuurent day of year: " + date1.getDayOfYear());

        System.out.println("date3 is after date2: "+date3.isAfter(date2));
    }
}
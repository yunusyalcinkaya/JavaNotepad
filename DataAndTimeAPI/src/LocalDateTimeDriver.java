import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeDriver {
    public static void main(String[] args) {
        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println("current date and time: " + dateTime1);
        System.out.println("4 months and 3 days after: "+
                dateTime1.plus(4, ChronoUnit.MONTHS).plus(3,ChronoUnit.DAYS));

        LocalDateTime dateTime2 = LocalDateTime.of(1998,9,22,21,20);
        System.out.println("dateTime2: "+dateTime2);

        LocalDate localDate = LocalDate.of(2021,9,10);
        LocalTime localTime = LocalTime.of(3,45);
        LocalDateTime dateTime3 = LocalDateTime.of(localDate,localTime);
        System.out.println("dateTime3: " + dateTime3);

        System.out.println("dateTime3 is after dateTime2: " + dateTime3.isAfter(dateTime2));

        System.out.println("I'm "+ChronoUnit.DAYS.between(dateTime2,LocalDateTime.now()) + " days old");
    }
}

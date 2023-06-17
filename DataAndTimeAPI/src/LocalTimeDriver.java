import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeDriver {
    public static void main(String[] args) {
        LocalTime time1 = LocalTime.now();
        System.out.println("current time: " + time1);
        System.out.println("3 hours later: " + time1.plus(3, ChronoUnit.HOURS));
        System.out.println("5 minutes ago: " + time1.minus(5,ChronoUnit.MINUTES));

        LocalTime time2 = LocalTime.parse("21:30");
        System.out.println("time2: " + time2);

        LocalTime time3 = LocalTime.of(8,40);
        System.out.println("time3: " + time3);

        System.out.println("time2 is after time3: "+time2.isAfter(time3));

    }
}

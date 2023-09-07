import java.util.Calendar;

public class DayOfWeek {
    static String calculateDay(int year, int month, int day){

        String[] days = {"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month -1,day);//? month = 0-11, January=0

        return days[calendar.get(Calendar.DAY_OF_WEEK)-1];
    }

    public static void main(String[] args) {

        String dayOfWeek = calculateDay(2022, 6, 18);

        System.out.println(dayOfWeek);
    }
}

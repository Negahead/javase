import sun.util.resources.cldr.aa.CalendarData_aa_ET;

import java.util.Calendar;
import java.util.Locale;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        /**
         * calendar type is gregory
         */
        System.out.println(calendar.getCalendarType());
        //calendar.add(Calendar.MONTH,1\);
        /**
         * the current calendar instance's maximum value of the specified field
         */
        System.out.println(calendar.getActualMaximum(Calendar.DATE)); // 28 days in Feb
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); // 28
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_WEEK)); // 7
        System.out.println(calendar.getActualMaximum(Calendar.HOUR_OF_DAY)); // 23
        System.out.println(calendar.getActualMaximum(Calendar.HOUR)); // 11,Field number for get and set indicating the hour of the morning or afternoon.

        System.out.println(calendar.getDisplayName(Calendar.MONTH,Calendar.SHORT, Locale.ENGLISH)); // Feb
        System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.SHORT, Locale.ENGLISH)); // Wed

        System.out.println(calendar.getDisplayName(Calendar.MONTH,Calendar.LONG,Locale.ENGLISH)); // February
        System.out.println(calendar.getDisplayName(Calendar.MONTH,Calendar.LONG,Locale.CHINA)); // 二月

        System.out.println(calendar.getFirstDayOfWeek()); // 1,starting from index 1,Sunday in Us,Monday in France

        System.out.println(calendar.getWeeksInWeekYear());// 52
        System.out.println(calendar.getWeekYear()); // 2018

        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // 3,Tuesday,starting from sunday of 1

        System.out.println(calendar.get(Calendar.WEEK_OF_MONTH)); // 4,the 4th week

        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)); // 4,day 1 through 7 always correspond to DAY_OF_WEEK_IN_MONTH 1,2 through 8 always correspond to DAY_OF_WEEK_IN_MONTH 2

        calendar.set(Calendar.DAY_OF_MONTH,1);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // 2
        System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.SHORT, Locale.ENGLISH));//Mon
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); // 31


        System.out.printf("%10s%10s%10s%10s%10s%10s%10s\n","Sun","Mon","Tue","Wed","Thu","Fri","Sat");
        int i;
        int j = calendar.get(Calendar.DAY_OF_WEEK);
        for(i = 1 ; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            if(i < j) {
                System.out.printf("%10s","");
            }
            System.out.printf("%10d",calendar.get(Calendar.DAY_OF_MONTH));
            if(calendar.get(Calendar.DAY_OF_WEEK) % 7 == 0) {
                System.out.println();
            }
            if(calendar.get(Calendar.DAY_OF_MONTH) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                System.out.println();
            }
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }


    }
}

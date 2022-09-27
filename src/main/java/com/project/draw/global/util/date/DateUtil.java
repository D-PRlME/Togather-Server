package com.project.draw.global.util.date;

import java.time.LocalDateTime;

public class DateUtil {

    public static String toTimeAgoFormat(LocalDateTime localDateTime) {

        LocalDateTime now = LocalDateTime.now();

        if (localDateTime.getYear() != now.getYear()) {
            return yearDifference(now, localDateTime) + "년전";
        } else if (getIntMonth(localDateTime) != getIntMonth(now)) {
            return monthDifference(now, localDateTime) + "월전";
        } else if (localDateTime.getDayOfMonth() != now.getDayOfMonth()) {
            return dayDifference(now, localDateTime) + "일전";
        } else if (localDateTime.getHour() != now.getHour()) {
            return hourDifference(now, localDateTime) + "시간전";
        } else if (localDateTime.getMinute() != now.getMinute()) {
            return minuteDifference(now, localDateTime) + "분전";
        } else {
            return "방금전";
        }
    }

    private static int yearDifference(LocalDateTime localDateTime1, LocalDateTime localDateTime2) {
        return localDateTime1.minusYears(localDateTime2.getYear()).getYear();
    }

    private static int monthDifference(LocalDateTime localDateTime1, LocalDateTime localDateTime2) {
        return getIntMonth(localDateTime1.minusMonths(getIntMonth(localDateTime2)));
    }

    private static int getIntMonth(LocalDateTime localDateTime){
        return localDateTime.getMonth().getValue();
    }

    private static int dayDifference(LocalDateTime localDateTime1, LocalDateTime localDateTime2) {
        return localDateTime1.minusDays(localDateTime2.getDayOfMonth()).getDayOfMonth();
    }

    private static int hourDifference(LocalDateTime localDateTime1, LocalDateTime localDateTime2) {
        return localDateTime1.minusHours(localDateTime2.getHour()).getHour();
    }

    private static int minuteDifference(LocalDateTime localDateTime1, LocalDateTime localDateTime2) {
        return localDateTime1.minusMinutes(localDateTime2.getMinute()).getMinute();
    }

}
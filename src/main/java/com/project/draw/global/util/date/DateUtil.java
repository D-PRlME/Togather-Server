package com.project.draw.global.util.date;

import java.time.LocalDateTime;

public class DateUtil {

    public static String createdAtToString(LocalDateTime localDateTime) {

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

    private static int yearDifference(LocalDateTime now, LocalDateTime localDateTime) {
        return now.minusYears(localDateTime.getYear()).getYear();
    }

    private static int monthDifference(LocalDateTime now, LocalDateTime localDateTime) {
        return getIntMonth(now.minusMonths(getIntMonth(localDateTime)));
    }

    private static int getIntMonth(LocalDateTime localDateTime){
        return localDateTime.getMonth().getValue();
    }

    private static int dayDifference(LocalDateTime now, LocalDateTime localDateTime) {
        return now.minusDays(localDateTime.getDayOfMonth()).getDayOfMonth();
    }

    private static int hourDifference(LocalDateTime now, LocalDateTime localDateTime) {
        return now.minusHours(localDateTime.getHour()).getHour();
    }

    private static int minuteDifference(LocalDateTime now, LocalDateTime localDateTime) {
        return now.minusMinutes(localDateTime.getMinute()).getMinute();
    }

}
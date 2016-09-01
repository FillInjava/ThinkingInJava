package com.java8.example;

import java.time.*;

/**
 * Created by liuguo on 2016/9/1.
 */
public class NewDateExample {

    public static void main(String[] args) {
        //Clock
        final Clock clock = Clock.systemUTC();

        System.out.println("date = [" + clock.instant() + "]");//date = [2016-09-01T01:49:45.055Z]
        System.out.println("millions = [" + clock.millis() + "]");// millions = [1472694585110]

        //LocalDate
        final LocalDate localDate = LocalDate.now();
        final LocalDate localDateFromLock = LocalDate.now(clock);

        System.out.println("localDate = [" + localDate + "]");
        System.out.println("localDateFromLock = [" + localDateFromLock + "]");

        //LocalTime
        final LocalTime localTime = LocalTime.now();
        final LocalTime localTimeFromLock = LocalTime.now(clock);

        System.out.println("localTime = [" + localTime + "]");
        System.out.println("localTimeFromLock = [" + localTimeFromLock + "]");

        //LocalDateTime
        final LocalDateTime localDateTime = LocalDateTime.now();
        final LocalDateTime dateTimeFromLock = LocalDateTime.now(clock);

        System.out.println("localDateTime = [" + localDateTime + "]");
        System.out.println("dateTimeFromLock = [" + dateTimeFromLock + "]");

        //ZonedDateTime
        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        final ZonedDateTime zonedDateTimeFromClock = ZonedDateTime.now(clock);
        final ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("zonedDateTime = [" + zonedDateTime + "]");
        System.out.println("zonedDateTimeFromClock = [" + zonedDateTimeFromClock + "]");
        System.out.println("zonedDateTimeFromZone = [" + zonedDateTimeFromZone + "]");

        final LocalDateTime from = LocalDateTime.of(2015, Month.APRIL, 16, 0, 0, 0);
        final LocalDateTime to = LocalDateTime.of(2016, Month.APRIL, 16, 23, 59, 59);
        final Duration duration = Duration.between(from, to);
        System.out.println("Duration in days: " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());

    }
}

package lan;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeZoneTest {

    public static void main(String[] args) {
        // 包含时区
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.withZoneSameInstant(ZoneId.of("America/New_York")));

        // 不包含时区
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // 时间偏移
        System.out.println(localDateTime.plusMinutes(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));;
        System.out.println(localDateTime.plusDays(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));;
        System.out.println(localDateTime.plusSeconds(-5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));;
        System.out.println(localDateTime.plusHours(-5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));;

        // utc 时间转换位不同时区时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("UTC: 0)" + formatter.format(ZonedDateTime.ofInstant(Instant.now(),ZoneId.of("UTC"))));
        System.out.println("Shanghai: +8)" + formatter.format(ZonedDateTime.ofInstant(Instant.now(),ZoneId.of("UTC")).withZoneSameInstant(ZoneId.systemDefault())));
        System.out.println("New_York: -5)" + formatter.format(ZonedDateTime.ofInstant(Instant.now(),ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("America/New_York"))));

    }
}

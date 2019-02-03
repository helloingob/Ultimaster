package de.fhl.ultimaster.gui.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeHelper {

    private static ZoneId ZONEID = ZoneId.of("Europe/Berlin");

    /** Add seconds to given timestamp (e.g. {@link System})
     *  1527228449.014232 - 2244 
     * @return timestamp in ms */
    public static String get(double timestamp, String time) {
        //Convert time string to double
        Double timeTimestamp = Double.parseDouble(time);

        //Add time to timestamp
        Double calculatedTimestamp = (timestamp + timeTimestamp) * 1000;
        return String.valueOf(calculatedTimestamp.longValue());
    }

    /** Calculates the timestamp, when the printer is completely booted
    * 1527228449.014232 - 2244 
    * @return timestamp with microseconds */
    public static double getBootTimestamp(de.fhl.ultimaster.api.v1.objects.json.System system) {
        return Double.parseDouble(system.getTime().getUtc()) - system.getUptime();
    }

    /** 2018-03-13T11:49:35 */
    public static String getFormattedTimestamp(String timestamp) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        ZonedDateTime zonedDateTime = Instant.parse(timestamp + "Z").atZone(getZoneId());
        return zonedDateTime.format(dateTimeFormatter);
    }

    /** 1527228449014 */
    public static String getFormattedEpoch(long timestamp) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        ZonedDateTime zonedDateTime = Instant.ofEpochMilli(timestamp).atZone(getZoneId());
        return zonedDateTime.format(dateTimeFormatter);
    }

    private static ZoneId getZoneId() {
        ZoneId zoneId = SessionManager.getZoneId();
        if (zoneId == null) {
            zoneId = ZONEID;
        }
        return zoneId;
    }

}

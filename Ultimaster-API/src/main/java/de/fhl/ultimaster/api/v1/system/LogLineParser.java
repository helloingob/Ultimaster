package de.fhl.ultimaster.api.v1.system;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import de.fhl.ultimaster.api.v1.objects.LogLine;

public class LogLineParser {

    public static LogLine getLogLine(String input) {
        //Not efficient.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm:ss", Locale.ENGLISH);

        LogLine logLine = new LogLine();
        String date = input.substring(0, 15);
        //Add year for parsing
        String convertedDate = "";
        String[] dateParts = date.split(" ");
        for (int i = 0; i < dateParts.length; i++) {
            String datePart = dateParts[i];
            //after month and day
            if (i == 2) {
                //year is from API-Server not PRINTER!
                convertedDate += Year.now().getValue() + " ";
            }
            convertedDate += datePart + " ";
        }
        logLine.setDate(LocalDateTime.parse(convertedDate.trim(), formatter));
        String metaData = input.substring(0, input.indexOf("]:") + 1);
        logLine.setPid(Integer.parseInt(metaData.substring(metaData.indexOf("[") + 1, metaData.indexOf("]"))));
        logLine.setProcess(metaData.substring(metaData.lastIndexOf(" ") + 1, metaData.indexOf("[")));
        logLine.setLine(input.substring(input.indexOf("]:") + 3, input.length() - 1));
        return logLine;
    }

}

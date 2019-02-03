package de.fhl.ultimaster.utils;

public class LogFormatter {

    public static String format(int statusCode, String contentType, String body) {
        return "Response (" + statusCode + "/" + contentType + ") => '" + body + "'";
    }

}

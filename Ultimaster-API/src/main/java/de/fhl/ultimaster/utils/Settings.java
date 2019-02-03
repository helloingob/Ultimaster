package de.fhl.ultimaster.utils;

public class Settings {

    public static class Info {
        public static final String APPLICATION_NAME = "Ultimaster";
    }

    public static class Connection {
        public static final Integer TIMEOUT = 15 * 1000;
        public static final String CONTENT_TYPE_JSON = "application/json";
        public static final String CONTENT_TYPE_CSV = "text/csv; charset=utf-8";
    }

}

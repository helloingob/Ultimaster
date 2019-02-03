package de.fhl.ultimaster.gui.utils;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Clients;

public class NotificationManager {

    private static final String POSITION = "top_center";
    private static final int DURATION = 5000;

    public static void showWarning(String msg) {
        showWarning(msg, null);
    }

    public static void showWarning(String msg, Component zkComponent) {
        showNotification(msg, Clients.NOTIFICATION_TYPE_WARNING, zkComponent);
    }

    public static void showLogin() {
        Clients.showNotification("Please log in!", Clients.NOTIFICATION_TYPE_ERROR, null, "middle_center", DURATION);
    }

    public static void showInfo(String msg) {
        showInfo(msg, null);
    }

    public static void showInfo(String msg, Component zkComponent) {
        showNotification(msg, Clients.NOTIFICATION_TYPE_INFO, zkComponent);
    }

    private static void showNotification(String msg, String type, Component zkComponent) {
        String position = POSITION;
        if (zkComponent != null) {
            position = "end_center";
        }
        Clients.showNotification(msg, type, zkComponent, position, DURATION);
    }

}

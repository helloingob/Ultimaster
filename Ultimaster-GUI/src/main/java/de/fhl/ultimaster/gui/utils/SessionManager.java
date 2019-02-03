package de.fhl.ultimaster.gui.utils;

import java.time.ZoneId;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Menuseparator;
import de.fhl.ultimaster.shared.user.UserTO;

public class SessionManager {

    private final static String USER_ATTRIB = "currentUser";

    private final static String LOGIN_ATTRIB = "loginMenuItem";
    private final static String USER_MANAGEMENT_ATTRIB = "userManagementMenuItem";
    private final static String SETTINGS_ATTRIB = "settingsMenuItem";
    private final static String SEPARATOR_ATTRIB = "separatorMenuItem";
    private final static String ZONEID_ATTRIB = "zoneid";

    public static UserTO getCurrentUser() {
        return (UserTO) Executions.getCurrent().getSession().getAttribute(USER_ATTRIB);
    }

    public static void setCurrentUser(UserTO user) {
        Executions.getCurrent().getSession().setAttribute(USER_ATTRIB, user);
    }

    public static void setLoginMenuItem(Menuitem menuitem) {
        Executions.getCurrent().getSession().setAttribute(LOGIN_ATTRIB, menuitem);
    }

    public static Menuitem getLoginMenuItem() {
        return (Menuitem) Executions.getCurrent().getSession().getAttribute(LOGIN_ATTRIB);
    }

    public static void setUserManagementMenuItem(Menuitem menuitem) {
        Executions.getCurrent().getSession().setAttribute(USER_MANAGEMENT_ATTRIB, menuitem);
    }

    public static Menuitem getUserManagementMenuItem() {
        return (Menuitem) Executions.getCurrent().getSession().getAttribute(USER_MANAGEMENT_ATTRIB);
    }

    public static void setSettingsMenuItem(Menuitem menuitem) {
        Executions.getCurrent().getSession().setAttribute(SETTINGS_ATTRIB, menuitem);
    }

    public static Menuitem getSettingsMenuItem() {
        return (Menuitem) Executions.getCurrent().getSession().getAttribute(SETTINGS_ATTRIB);
    }

    public static void setZoneId(ZoneId zoneId) {
        Executions.getCurrent().getSession().setAttribute(ZONEID_ATTRIB, zoneId);
    }

    public static ZoneId getZoneId() {
        return (ZoneId) Executions.getCurrent().getSession().getAttribute(ZONEID_ATTRIB);
    }

    public static void setMainMenuSeparator(Menuseparator separator) {
        Executions.getCurrent().getSession().setAttribute(SEPARATOR_ATTRIB, separator);
    }

    public static Menuseparator getMainMenuSeparator() {
        return (Menuseparator) Executions.getCurrent().getSession().getAttribute(SEPARATOR_ATTRIB);
    }

}

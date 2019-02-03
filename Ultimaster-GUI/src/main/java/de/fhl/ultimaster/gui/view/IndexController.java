package de.fhl.ultimaster.gui.view;

import java.util.TimeZone;

import org.pmw.tinylog.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.ClientInfoEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Menuseparator;

import de.fhl.ultimaster.api.v1.camera.CameraGet;
import de.fhl.ultimaster.gui.utils.NotificationManager;
import de.fhl.ultimaster.gui.utils.SessionManager;
import de.fhl.ultimaster.gui.utils.WindowManager;
import de.fhl.ultimaster.shared.printer.PrinterDAO;
import de.fhl.ultimaster.shared.user.UserTO;

public class IndexController extends GenericForwardComposer<Component> {

    private static final long serialVersionUID = -7329458045619356630L;
    private Menuitem mniLogin;
    private Menuitem mniUserManagement;
    private Menuitem mniSettings;
    private Menuseparator mnsLogin;

    @Override
    public void doAfterCompose(Component comp) {
        try {
            super.doAfterCompose(comp);
        } catch (Exception e) {
            Logger.error(e);
        }
        init();
    }

    public void onClientInfo$bdlMain(ClientInfoEvent evt) {
        TimeZone timeZone = evt.getTimeZone();
        SessionManager.setZoneId(timeZone.toZoneId());
    }

    private void init() {
        SessionManager.setLoginMenuItem(mniLogin);
        SessionManager.setUserManagementMenuItem(mniUserManagement);
        SessionManager.setSettingsMenuItem(mniSettings);
        SessionManager.setMainMenuSeparator(mnsLogin);

        UserTO user = SessionManager.getCurrentUser();
        if (user != null) {
            SessionManager.getLoginMenuItem().setLabel("Logout");
            if (user.isAdmin()) {
                SessionManager.getUserManagementMenuItem().setVisible(true);
                SessionManager.getSettingsMenuItem().setVisible(true);
                SessionManager.getMainMenuSeparator().setVisible(true);
            }
        }
    }

    public void onClick$mniMaterials() {
        WindowManager.createWindow("Materials", "/materials/materialslist.zul", null, true);
    }

    public void onClick$mniSettings() {
        WindowManager.createWindow("Printer Connection Settings", "/settings/settingsform.zul", null, false);
    }

    public void onClick$mniSystem() {
        WindowManager.createWindow("System Information", "/system/systemform.zul", null, false);
    }

    public void onClick$mniDiagnostics() {
        WindowManager.createWindow("Diagnostics", "/diagnostics/diagnostics.zul", null, true);
    }

    public void onClick$mniUserManagement() {
        WindowManager.createWindow("User Management", "/usermanagement/userlist.zul", null, true);
    }

    public void onClick$mniCamera() {
        Executions.getCurrent().sendRedirect(CameraGet.get(PrinterDAO.get()).getFeed(), "_blank");
    }

    public void onClick$mniLogin() {
        if (SessionManager.getCurrentUser() == null) {
            WindowManager.createWindow("Login", "/usermanagement/loginform.zul", null, false);
        } else {
            NotificationManager.showInfo("Successfully logged out.");
            SessionManager.setCurrentUser(null);
            SessionManager.getLoginMenuItem().setLabel("Login");
            SessionManager.getUserManagementMenuItem().setVisible(false);
            SessionManager.getSettingsMenuItem().setVisible(false);
            SessionManager.getMainMenuSeparator().setVisible(false);
        }

    }

}

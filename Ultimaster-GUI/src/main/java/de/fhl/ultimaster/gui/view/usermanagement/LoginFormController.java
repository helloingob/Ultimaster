package de.fhl.ultimaster.gui.view.usermanagement;

import org.pmw.tinylog.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Textbox;
import de.fhl.ultimaster.gui.utils.NotificationManager;
import de.fhl.ultimaster.gui.utils.SessionManager;
import de.fhl.ultimaster.shared.user.UserDAO;
import de.fhl.ultimaster.shared.user.UserTO;

public class LoginFormController extends GenericForwardComposer<Component> {

    private static final long serialVersionUID = -8287200641305705983L;

    private Textbox tbxMail;
    private Textbox tbxPassword;

    @Override
    public void doAfterCompose(Component comp) {
        try {
            super.doAfterCompose(comp);
        } catch (Exception e) {
            Logger.error(e);
        }
    }

    public void onOK$tbxPassword() {
        onClick$btnOk();
    }

    public void onClick$btnOk() {
        if (isInputValid()) {
            UserTO user = UserDAO.get(tbxMail.getText(), tbxPassword.getText());
            if (user != null) {
                NotificationManager.showInfo("Successfully logged in.");
                SessionManager.setCurrentUser(user);
                SessionManager.getLoginMenuItem().setLabel("Logout");
                if (user.isAdmin()) {
                    SessionManager.getUserManagementMenuItem().setVisible(true);
                    SessionManager.getSettingsMenuItem().setVisible(true);
                    SessionManager.getMainMenuSeparator().setVisible(true);
                }
                this.self.detach();
            } else {
                NotificationManager.showWarning("Invalid credentials!");
            }
        }
    }

    private boolean isInputValid() {
        if (tbxMail.getText().isEmpty() && tbxMail.getText().length() <= 100) {
            NotificationManager.showWarning("Please enter your Email!", tbxMail);
            return false;
        }
        if (tbxPassword.getText().isEmpty() && tbxMail.getText().length() <= 100) {
            NotificationManager.showWarning("Please enter your Password!", tbxPassword);
            return false;
        }
        return true;
    }

}

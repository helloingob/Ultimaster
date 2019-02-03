package de.fhl.ultimaster.gui.view.usermanagement;

import org.pmw.tinylog.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Textbox;
import de.fhl.ultimaster.gui.utils.NotificationManager;
import de.fhl.ultimaster.shared.user.UserDAO;
import de.fhl.ultimaster.shared.user.UserTO;

public class UserFormController extends GenericForwardComposer<Component> {

    private static final long serialVersionUID = -721161012740802093L;
    private Textbox tbxName;
    private Textbox tbxEmail;
    private Textbox tbxPassword;
    private Checkbox chbxAdmin;

    private UserTO user;

    @Override
    public void doAfterCompose(Component comp) {
        try {
            super.doAfterCompose(comp);
        } catch (Exception e) {
            Logger.error(e);
        }
        init();
    }

    private void init() {
        if (arg.containsKey("user")) {
            user = (UserTO) arg.get("user");
            prefillForm();
        }
    }

    private void prefillForm() {
        tbxName.setText(user.getName());
        tbxEmail.setText(user.getMail());
        tbxPassword.setPlaceholder("**********************");
        chbxAdmin.setChecked(user.isAdmin());
    }

    public void onClick$btnOk() {
        if (isInputValid()) {
            UserTO tempUser = new UserTO();
            tempUser.setName(tbxName.getText());
            tempUser.setMail(tbxEmail.getText());
            tempUser.setAdmin(chbxAdmin.isChecked());

            //Add
            if (user == null) {
                tempUser.setPassword(tbxPassword.getText());
                if (UserDAO.insert(tempUser)) {
                    NotificationManager.showInfo("User successfully saved.");
                    Events.postEvent("onReload", this.self, null);
                    this.self.detach();
                } else {
                    NotificationManager.showWarning("Couldn't save user!");
                }
            } else {
                //Edit  
                tempUser.setId(user.getId());
                if (!tbxPassword.getText().isEmpty()) {
                    tempUser.setPassword(tbxPassword.getText());
                } else {
                    tempUser.setPassword(user.getPassword());
                }
                if (UserDAO.update(tempUser)) {
                    NotificationManager.showInfo("User successfully updated.");
                    Events.postEvent("onReload", this.self, null);
                    this.self.detach();
                } else {
                    NotificationManager.showWarning("Couldn't update user!");
                }
            }
        }
    }

    private boolean isInputValid() {
        if (tbxName.getText().isEmpty()) {
            NotificationManager.showWarning("Please enter your Name!", tbxName);
            return false;
        }
        if (tbxEmail.getText().isEmpty()) {
            NotificationManager.showWarning("Please enter your Email!", tbxEmail);
            return false;
        }
        if (tbxPassword.getText().isEmpty() && user == null) {
            NotificationManager.showWarning("Please enter your Password!", tbxPassword);
            return false;
        }
        return true;
    }

}

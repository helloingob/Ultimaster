package de.fhl.ultimaster.gui.view.usermanagement;

import java.util.HashMap;
import java.util.Map;
import org.pmw.tinylog.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import de.fhl.ultimaster.gui.utils.NotificationManager;
import de.fhl.ultimaster.gui.utils.WindowManager;
import de.fhl.ultimaster.shared.user.UserDAO;
import de.fhl.ultimaster.shared.user.UserTO;

public class UserListController extends GenericForwardComposer<Component> {

    private static final long serialVersionUID = -8287200641305705983L;
    private Listbox lbxUsers;

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
        fillUsers();
    }

    private void fillUsers() {
        lbxUsers.getItems().clear();
        for (UserTO user : UserDAO.get()) {
            addListitem(user);
        }
    }

    private void addListitem(UserTO user) {
        Listitem listitem = new Listitem();
        listitem.appendChild(new Listcell(user.getName()));
        listitem.appendChild(new Listcell(user.getMail()));
        listitem.appendChild(new Listcell(user.isAdmin() ? "Yes" : "No"));
        listitem.setValue(user);
        lbxUsers.appendChild(listitem);
    }

    public void onClick$btnAddUser() {
        Window window = WindowManager.createWindow("Add User", "/usermanagement/userform.zul", null, false);
        window.addEventListener("onReload", new EventListener<Event>() {
            public void onEvent(Event event) throws Exception {
                fillUsers();
            }
        });
    }

    public void onClick$btnDeleteUser() {
        Listitem listitem = lbxUsers.getSelectedItem();
        if (listitem == null) {
            NotificationManager.showWarning("Please select an user", lbxUsers);
        } else {
            UserTO user = (UserTO) listitem.getValue();
            Messagebox.show("Really delete user '" + user.getMail() + "'", "Delete User?", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new EventListener<Event>() {
                @Override
                public void onEvent(Event event) throws InterruptedException {
                    if (Events.ON_OK.equals(event.getName())) {
                        if (UserDAO.delete(user)) {
                            NotificationManager.showInfo("User successfully deleted.");
                            fillUsers();
                        } else {
                            NotificationManager.showInfo("Couldn't delete User!");
                        }
                    }
                }
            });
        }
    }

    public void onClick$btnEditUser() {
        Listitem listitem = lbxUsers.getSelectedItem();
        if (listitem == null) {
            NotificationManager.showWarning("Please select an user", lbxUsers);
        } else {
            UserTO user = (UserTO) listitem.getValue();
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("user", user);
            Window window = WindowManager.createWindow("Edit User", "/usermanagement/userform.zul", parameter, false);
            window.addEventListener("onReload", new EventListener<Event>() {
                @Override
                public void onEvent(Event event) throws Exception {
                    fillUsers();
                }
            });
        }
    }

}

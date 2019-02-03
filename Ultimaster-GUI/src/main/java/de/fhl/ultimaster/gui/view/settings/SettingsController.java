package de.fhl.ultimaster.gui.view.settings;

import org.pmw.tinylog.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Textbox;
import de.fhl.ultimaster.api.v1.auth.request.AuthRequestPost;
import de.fhl.ultimaster.api.v1.auth.verify.AuthVerifyGet;
import de.fhl.ultimaster.api.v1.objects.json.Credential;
import de.fhl.ultimaster.gui.utils.NotificationManager;
import de.fhl.ultimaster.shared.printer.Printer;
import de.fhl.ultimaster.shared.printer.PrinterDAO;

public class SettingsController extends GenericForwardComposer<Component> {

    private static final long serialVersionUID = -937267959458214777L;
    private Textbox tbxHost;
    private Textbox tbxId;
    private Textbox tbxKey;

    private Printer printer;

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
        printer = PrinterDAO.get();
        if (printer != null) {
            tbxHost.setText(printer.getHost());
            tbxId.setText(printer.getPrinterId());
            tbxKey.setText(printer.getPrinterKey());
        }
    }

    private Printer getPrinter() {
        Printer printer = new Printer();
        printer.setHost(tbxHost.getText());

        if (!tbxId.getText().isEmpty()) {
            printer.setPrinterId(tbxId.getText());
        }

        if (!tbxKey.getText().isEmpty()) {
            printer.setPrinterKey(tbxKey.getText());
        }
        return printer;
    }

    public void onClick$btnOk() {
        if (isInputValid()) {

            boolean success = false;
            if (printer == null) {
                if (PrinterDAO.save(getPrinter())) {
                    success = true;
                } else {
                    success = false;
                }
            } else {
                Printer updatedPrinter = getPrinter();
                updatedPrinter.setId(printer.getId());
                if (PrinterDAO.update(updatedPrinter)) {
                    success = true;
                } else {
                    success = false;
                }
            }

            if (success) {
                NotificationManager.showInfo("Printer Settings successfully set.");
                this.self.detach();
            } else {
                NotificationManager.showInfo("Printer Settings NOT set!");
            }
        }
    }

    private boolean isInputValid() {
        if (tbxHost.getText().isEmpty() && tbxHost.getText().length() <= 100) {
            NotificationManager.showWarning("Please enter a host!", tbxHost);
            return false;
        }
        return true;
    }

    public void onClick$btnRequest() {
        if (isInputValid()) {
            Credential credential = AuthRequestPost.post(getPrinter(), "Ultimaster", "Ultimaster API", null, null);
            if (credential != null) {
                tbxId.setText(credential.getId());
                tbxKey.setText(credential.getKey());
            }
        }
    }

    private boolean isInputComplete() {
        if (!isInputValid()) {
            return false;
        }
        if (tbxId.getText().isEmpty() && tbxId.getText().length() <= 100) {
            NotificationManager.showWarning("Please enter a valid id!", tbxId);
            return false;
        }
        if (tbxKey.getText().isEmpty() && tbxKey.getText().length() <= 100) {
            NotificationManager.showWarning("Please enter a valid key!", tbxKey);
            return false;
        }
        return true;
    }

    public void onClick$btnVerify() {
        if (isInputComplete()) {
            if (AuthVerifyGet.get(getPrinter())) {
                NotificationManager.showInfo("Credentials successfully verified.");
            } else {
                NotificationManager.showWarning("Couldn't verify credentials!");
            }
        }
    }

}

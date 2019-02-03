package de.fhl.ultimaster.gui.view.printjob;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.pmw.tinylog.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import de.fhl.ultimaster.gui.utils.NotificationManager;
import de.fhl.ultimaster.gui.utils.SessionManager;
import de.fhl.ultimaster.shared.printjob.PrintJobDAO;
import de.fhl.ultimaster.shared.printjob.PrintJobTO;

public class PrintJobFormController extends GenericForwardComposer<Component> {

    private static final long serialVersionUID = -937267959458214777L;
    public static final String FILE_SEPERATOR = System.getProperty("file.separator");
    private Label lblFilename;
    private Textbox tbxName;
    private Checkbox chbxActive;
    private Button btnUpload;

    private PrintJobTO printJob;

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
        if (arg.containsKey("printjob")) {
            printJob = (PrintJobTO) arg.get("printjob");
            prefillForm();
        }
    }

    private void prefillForm() {
        tbxName.setText(printJob.getName());
        lblFilename.setValue(printJob.getFilename());
        chbxActive.setChecked(printJob.isActive());
    }

    public void onUpload$btnUpload(UploadEvent uploadEvent) {
        try {
            if (printJob == null) {
                printJob = new PrintJobTO();
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            String uploadedFileName = uploadEvent.getMedia().getName();
            printJob.setFilename(uploadedFileName);
            lblFilename.setValue(uploadedFileName);
            InputStream inputStream = uploadEvent.getMedia().getStreamData();
            byte[] buffer = new byte[1024 * 8];
            for (int count; (count = inputStream.read(buffer)) != -1;) {
                bos.write(buffer, 0, count);
            }
            printJob.setBytes(bos != null ? bos.toByteArray() : null);
            inputStream.close();
        } catch (Exception e) {
            Logger.error(e);
        }
    }

    public void onClick$btnOk() {
        if (isInputValid()) {
            printJob.setName(tbxName.getText());
            printJob.setUser(SessionManager.getCurrentUser());
            printJob.setActive(chbxActive.isChecked());

            if (printJob.getId() == null) {
                printJob.setOrder(PrintJobDAO.getNextOrder());
                if (PrintJobDAO.insert(printJob)) {
                    NotificationManager.showInfo("Print Job successfully queued.");
                    Events.postEvent("onReload", this.self, null);
                    this.self.detach();
                } else {
                    NotificationManager.showWarning("Couldn't queue Print Job!");
                }
            } else {
                if (PrintJobDAO.update(printJob)) {
                    NotificationManager.showInfo("Print Job successfully updated.");
                    Events.postEvent("onReload", this.self, null);
                    this.self.detach();
                } else {
                    NotificationManager.showWarning("Couldn't update Print Job!");
                }
            }
        }
    }

    private boolean isInputValid() {
        if (tbxName.getText().isEmpty() && tbxName.getText().length() <= 100) {
            NotificationManager.showWarning("Please enter your Name!", tbxName);
            return false;
        }
        if (printJob.getBytes() == null) {
            NotificationManager.showWarning("Please upload a File!", btnUpload);
            return false;
        }
        return true;
    }

}

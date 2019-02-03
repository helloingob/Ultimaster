package de.fhl.ultimaster.gui.view.system;

import org.apache.commons.io.FileUtils;
import org.pmw.tinylog.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Textbox;
import de.fhl.ultimaster.api.v1.system.SystemGet;
import de.fhl.ultimaster.gui.utils.TimeHelper;
import de.fhl.ultimaster.shared.printer.PrinterDAO;

public class SystemController extends GenericForwardComposer<Component> {

    private static final long serialVersionUID = -937267959458214777L;

    private Textbox tbxSystem;
    private Textbox tbxHostname;
    private Textbox tbxPlatform;
    private Textbox tbxFirmware;
    private Textbox tbxMemory;
    private Textbox tbxLanguage;
    private Textbox tbxCountry;
    private Textbox tbxTime;
    private Textbox tbxUptime;

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
        de.fhl.ultimaster.api.v1.objects.json.System system = SystemGet.get(PrinterDAO.get());
        if (system != null) {
            tbxSystem.setText(system.getVariant() + " - " + system.getType());
            tbxHostname.setText(system.getHostname());
            tbxPlatform.setText(system.getPlatform());
            tbxFirmware.setText(system.getFirmware());
            tbxMemory.setText(FileUtils.byteCountToDisplaySize(system.getMemory().getUsed()) + " / " + FileUtils.byteCountToDisplaySize(system.getMemory().getTotal()));
            tbxLanguage.setText(system.getLanguage());
            tbxCountry.setText(system.getCountry());
            tbxTime.setText(formatTime(system.getTime().getUtc()));
            tbxUptime.setText(formatUptime(system));
        }
    }

    private String formatTime(String utc) {
        Double utcTimestamp = Double.parseDouble(utc);
        utcTimestamp = utcTimestamp * 1000;
        return TimeHelper.getFormattedEpoch(utcTimestamp.longValue());
    }

    private String formatUptime(de.fhl.ultimaster.api.v1.objects.json.System system) {
        Double bootTimestamp = TimeHelper.getBootTimestamp(system);
        bootTimestamp = bootTimestamp * 1000;
        return TimeHelper.getFormattedEpoch(bootTimestamp.longValue());
    }

}

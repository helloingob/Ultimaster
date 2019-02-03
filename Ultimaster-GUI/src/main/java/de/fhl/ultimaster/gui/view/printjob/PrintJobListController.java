package de.fhl.ultimaster.gui.view.printjob;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.pmw.tinylog.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Box;
import org.zkoss.zul.Button;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Progressmeter;
import org.zkoss.zul.Timer;
import org.zkoss.zul.Window;
import de.fhl.ultimaster.api.v1.history.print_jobs.HistoryPrintJobsGet;
import de.fhl.ultimaster.api.v1.objects.json.PrintJob;
import de.fhl.ultimaster.api.v1.objects.json.PrintJobHistoric;
import de.fhl.ultimaster.api.v1.print_job.PrintJobGet;
import de.fhl.ultimaster.api.v1.print_job.state.PrintJobStatePut;
import de.fhl.ultimaster.api.v1.print_job.state.PrinterState;
import de.fhl.ultimaster.gui.utils.NotificationManager;
import de.fhl.ultimaster.gui.utils.SessionManager;
import de.fhl.ultimaster.gui.utils.TimeHelper;
import de.fhl.ultimaster.gui.utils.WindowManager;
import de.fhl.ultimaster.shared.printer.Printer;
import de.fhl.ultimaster.shared.printer.PrinterDAO;
import de.fhl.ultimaster.shared.printjob.PrintJobDAO;
import de.fhl.ultimaster.shared.printjob.PrintJobTO;

public class PrintJobListController extends GenericForwardComposer<Component> {

    private static final long serialVersionUID = -937267959458214777L;
    private Listbox lbxPrintJobQueue;
    private Listbox lbxPrintJobHistory;
    private Listheader lhdBegin;
    private Listheader lhdEnd;
    private Hbox hbxPrintJob;
    private Button btnQueue;
    private Label lblName;
    private Label lblSource;
    private Label lblBegin;
    private Label lblState;
    private Label lblTime;
    private Progressmeter pgmProgress;
    private Box boxPrintJob;
    private Timer tmrRefresh;

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

        fillHistory();
        fillQueue();
        initTimer();

        toggleQueueButton(printer.isQueueActive());

        lhdBegin.setSortAscending(new DateBeginComparator(true));
        lhdEnd.setSortDescending(new DateEndComparator(false));
    }

    private void initTimer() {
        //Refresh 5 secs
        tmrRefresh.setDelay(5 * 1000);
        tmrRefresh.start();
        tmrRefresh.setRepeats(true);
        tmrRefresh.addEventListener(Events.ON_TIMER, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                getCurrentPrintJob(PrintJobGet.get(printer));
            }
        });
    }

    private void fillQueue() {
        lbxPrintJobQueue.getItems().clear();
        for (PrintJobTO printJob : PrintJobDAO.get()) {
            addPrintJobQueueListitem(printJob);
        }
    }

    private void fillHistory() {
        lbxPrintJobHistory.getItems().clear();
        for (PrintJobHistoric printJobHistoric : HistoryPrintJobsGet.get(printer, null, null)) {
            addPrintJobHistoryListitem(printJobHistoric);
        }
    }

    private void addPrintJobHistoryListitem(PrintJobHistoric printJobHistoric) {
        Listitem listitem = new Listitem();
        listitem.appendChild(new Listcell(TimeHelper.getFormattedTimestamp(printJobHistoric.getDatetimeStarted())));
        if (printJobHistoric.getDatetimeFinished() != null) {
        	listitem.appendChild(new Listcell(TimeHelper.getFormattedTimestamp(printJobHistoric.getDatetimeFinished())));
        }
        listitem.appendChild(new Listcell(printJobHistoric.getName()));
        listitem.appendChild(new Listcell(printJobHistoric.getSource()));
        listitem.setValue(printJobHistoric);
        lbxPrintJobHistory.appendChild(listitem);
    }

    private void addPrintJobQueueListitem(PrintJobTO printJob) {
        Listitem listitem = new Listitem();
        listitem.appendChild(new Listcell(String.valueOf(lbxPrintJobQueue.getItemCount() + 1)));
        listitem.appendChild(new Listcell(printJob.getName()));
        listitem.appendChild(new Listcell(printJob.getFilename()));
        listitem.appendChild(new Listcell(printJob.isActive() ? "Yes" : "No"));
        listitem.appendChild(new Listcell(printJob.getUser().getName()));
        listitem.setValue(printJob);
        lbxPrintJobQueue.appendChild(listitem);
    }

    public void onClick$btnAddPrintJob() {
        if (SessionManager.getCurrentUser() != null) {
            Window window = WindowManager.createWindow("Add Print Job", "/printjob/printjobform.zul", null, false);
            window.addEventListener("onReload", new EventListener<Event>() {
                public void onEvent(Event event) throws Exception {
                    fillQueue();
                }
            });
        } else {
            NotificationManager.showLogin();
        }
    }

    public void onClick$btnRemovePrintJob() {
        if (SessionManager.getCurrentUser() != null) {
            Listitem listitem = lbxPrintJobQueue.getSelectedItem();
            if (listitem == null) {
                NotificationManager.showWarning("Please select a Print Job", lbxPrintJobQueue);
            } else {
                PrintJobTO printJob = (PrintJobTO) listitem.getValue();
                Messagebox.show("Really delete print job '" + printJob.getName() + "'", "Delete Print Job?", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new EventListener<Event>() {
                    @Override
                    public void onEvent(Event event) throws InterruptedException {
                        if (Events.ON_OK.equals(event.getName())) {
                            if (PrintJobDAO.delete(printJob)) {
                                NotificationManager.showInfo("Print Job successfully deleted.");
                                fillQueue();
                            } else {
                                NotificationManager.showWarning("Couldn't delete Print Job!");
                            }
                        }
                    }
                });
            }
        } else {
            NotificationManager.showLogin();
        }
    }

    public void onClick$btnEditPrintJob() {
        if (SessionManager.getCurrentUser() != null) {
            Listitem listitem = lbxPrintJobQueue.getSelectedItem();
            if (listitem == null) {
                NotificationManager.showWarning("Please select a Print Job", lbxPrintJobQueue);
            } else {
                PrintJobTO printJob = (PrintJobTO) listitem.getValue();
                Map<String, Object> parameter = new HashMap<String, Object>();
                parameter.put("printjob", printJob);
                Window window = WindowManager.createWindow("Edit Print Job", "/printjob/printjobform.zul", parameter, false);
                window.addEventListener("onReload", new EventListener<Event>() {
                    public void onEvent(Event event) throws Exception {
                        fillQueue();
                    }
                });
            }
        } else {
            NotificationManager.showLogin();
        }
    }

    public void onClick$btnMovePrintJobUp() {
        if (SessionManager.getCurrentUser() != null) {
            Listitem listitem = lbxPrintJobQueue.getSelectedItem();
            if (listitem == null) {
                NotificationManager.showWarning("Please select a Print Job", lbxPrintJobQueue);
            } else {
                if (listitem.getIndex() - 1 >= 0) {
                    lbxPrintJobQueue.insertBefore(listitem, lbxPrintJobQueue.getItemAtIndex(listitem.getIndex() - 1));
                    lbxPrintJobQueue.setSelectedItem(listitem);
                    updatePrintJobOrder();
                }
            }
        } else {
            NotificationManager.showLogin();
        }
    }

    public void onClick$btnMovePrintJobDown() {
        if (SessionManager.getCurrentUser() != null) {
            Listitem listitem = lbxPrintJobQueue.getSelectedItem();
            if (listitem == null) {
                NotificationManager.showWarning("Please select a Print Job", lbxPrintJobQueue);
            } else {
                if (listitem.getIndex() + 2 <= lbxPrintJobQueue.getItemCount()) {
                    lbxPrintJobQueue.insertBefore(listitem, lbxPrintJobQueue.getItemAtIndex(listitem.getIndex() + 2));
                    lbxPrintJobQueue.setSelectedItem(listitem);
                    updatePrintJobOrder();
                }
            }
        } else {
            NotificationManager.showLogin();
        }
    }

    private void updatePrintJobOrder() {
        for (Listitem listitem : lbxPrintJobQueue.getItems()) {
            PrintJobTO printJob = listitem.getValue();
            printJob.setOrder(listitem.getIndex());
            PrintJobDAO.update(printJob);
        }
    }

    private void toggleQueueButton(boolean active) {
        if (active) {
            btnQueue.setIconSclass("z-icon-stop");
            btnQueue.setTooltiptext("Stop Queue");
        } else {
            btnQueue.setIconSclass("z-icon-play");
            btnQueue.setTooltiptext("Start");
        }
    }

    public void onClick$btnQueue() {
        if (SessionManager.getCurrentUser() != null) {
            if (btnQueue.getIconSclass().equals("z-icon-play")) {
                if (lbxPrintJobQueue.getItems().size() > 0) {
                    activeQueue(true);
                    getCurrentPrintJob(PrintJobGet.get(printer));
                    toggleQueueButton(true);
                    NotificationManager.showInfo("Print Job Queue started.");
                } else {
                    NotificationManager.showWarning("Please add a Print Job Queue first!", lbxPrintJobQueue);
                }
            } else {
                activeQueue(false);
                toggleQueueButton(false);
                NotificationManager.showInfo("Print Job Queue stopped.");
            }
        } else {
            NotificationManager.showLogin();
        }
    }

    private void activeQueue(boolean active) {
        printer.setQueueActive(active);
        PrinterDAO.update(printer);
    }

    private void getCurrentPrintJob(PrintJob printJob) {
        if (printJob != null) {
            lblName.setValue(printJob.getName());
            lblSource.setValue(printJob.getSource());
            lblBegin.setValue(TimeHelper.getFormattedTimestamp(printJob.getDatetimeStarted()));
            lblState.setValue(printJob.getState().toString());
            lblTime.setValue(DurationFormatUtils.formatDuration(printJob.getTimeElapsed() * 1000, "HH:mm:ss", true) + " / " + DurationFormatUtils.formatDuration(printJob.getTimeTotal() * 1000, "HH:mm:ss", true));
            Double progress = Double.parseDouble(printJob.getProgress());
            progress = progress * 100;
            pgmProgress.setValue(progress.intValue());
            hbxPrintJob.setVisible(true);
        } else {
            hbxPrintJob.setVisible(false);
        }
        boxPrintJob.invalidate();
    }

    public void onClick$btnPausePrintJob() {
        if (PrintJobStatePut.put(printer, PrinterState.PAUSE)) {
            NotificationManager.showInfo("Print Job paused.");
        } else {
            NotificationManager.showInfo("Couldn't pause Print Job!");
        }
    }

    public void onClick$btnStopPrintJob() {
        if (PrintJobStatePut.put(printer, PrinterState.ABORT)) {
            NotificationManager.showInfo("Print Job stopped.");
        } else {
            NotificationManager.showInfo("Couldn't stop Print Job!");
        }
    }

}

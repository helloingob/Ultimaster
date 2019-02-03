package de.fhl.ultimaster.central;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.pmw.tinylog.Logger;
import de.fhl.ultimaster.api.v1.auth.verify.AuthVerifyGet;
import de.fhl.ultimaster.api.v1.objects.json.PrintJobAccepted;
import de.fhl.ultimaster.api.v1.print_job.PrintJobPost;
import de.fhl.ultimaster.api.v1.printer.status.PrinterStatus;
import de.fhl.ultimaster.api.v1.printer.status.PrinterStatusGet;
import de.fhl.ultimaster.shared.printer.Printer;
import de.fhl.ultimaster.shared.printer.PrinterDAO;
import de.fhl.ultimaster.shared.printjob.PrintJobDAO;
import de.fhl.ultimaster.shared.printjob.PrintJobTO;

public class CentralMain {

    public static void main(String[] args) {
        Printer printer = PrinterDAO.get();
        //Printer set?
        if (printer != null) {
            //Credentials set?
            if (printer.getPrinterId() != null & printer.getPrinterKey() != null) {
                //Authorized?
                if (AuthVerifyGet.get(printer)) {
                    //Printer idling?
                    if (PrinterStatusGet.get(printer).equals(PrinterStatus.IDLE)) {
                        //Queue active?
                        if (printer.isQueueActive()) {
                            PrintJobTO printJob = PrintJobDAO.getNext();
                            File file = getFileFromBytes(printJob.getBytes());
                            if (file != null) {
                                PrintJobAccepted printJobAccepted = PrintJobPost.post(printer, printJob.getName(), file);
                                Logger.debug(printJobAccepted);
                                if (printJobAccepted.getMessage().equals("Print job started")) {
                                    Logger.info("Printjob successfully added.");
                                    PrintJobDAO.delete(printJob);
                                } else {
                                    Logger.error("Couldn't add Printjob!");
                                }
                            } else {
                                Logger.error("Couldn't get file from database!");
                            }
                        } else {
                            Logger.error("Queue is inactive!");
                        }
                    } else {
                        Logger.error("Printer is NOT idling!");
                    }
                } else {
                    Logger.error("Wrong credentials!");
                }
            } else {
                Logger.error("No credentials found!");
            }
        } else {
            Logger.error("No printer found!");
        }
    }

    public static File getFileFromBytes(byte[] bytes) {
        File tempFile = null;
        try {
            tempFile = File.createTempFile(String.valueOf(bytes.hashCode()), ".tmp");
            tempFile.deleteOnExit();
            Files.write(tempFile.toPath(), bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempFile;
    }

}

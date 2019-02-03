package org.ultimaster.shared.printer;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.shared.printer.Printer;
import de.fhl.ultimaster.shared.printer.PrinterDAO;

public class PrinterDAOTest {

    @Test
    public void CRU() {
        Printer printer1 = new Printer();
        printer1.setHost("localhost");
        Assert.assertTrue(PrinterDAO.save(printer1));
        Printer printer2 = PrinterDAO.get();
        Assert.assertNotNull(printer2);
        Assert.assertEquals(printer2.getHost(), "localhost");
        printer2.setPrinterId("1337");
        printer2.setPrinterKey("-");
        Assert.assertTrue(PrinterDAO.update(printer2));
        Printer printer3 = PrinterDAO.get();
        Assert.assertEquals(printer3.getPrinterId(), "1337");
        Assert.assertEquals(printer3.getPrinterKey(), "-");
    }

}

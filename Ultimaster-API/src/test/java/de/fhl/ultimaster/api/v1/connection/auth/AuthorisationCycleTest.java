package de.fhl.ultimaster.api.v1.connection.auth;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.auth.check.id.AuthCheckIdGet;
import de.fhl.ultimaster.api.v1.auth.check.id.AuthorizationStatus;
import de.fhl.ultimaster.api.v1.auth.request.AuthRequestPost;
import de.fhl.ultimaster.api.v1.auth.verify.AuthVerifyGet;
import de.fhl.ultimaster.api.v1.objects.json.Credential;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;
import de.fhl.ultimaster.shared.printer.Printer;

public class AuthorisationCycleTest {

    //Minutes
    private static final int WAIT_TIMER = 5;

    @Test
    @Ignore
    public void testAuth() {
        //Get Id
        Printer printer = TestPrinter.getInstance().getPrinter();
        Credential credential = AuthRequestPost.post(printer, "Ultimaster", "Ultimaster API", null, null);
        System.out.println("Id acquired =>" + credential);
        Assert.assertNotNull(credential);
        Assert.assertNotNull(credential.getId());
        Assert.assertNotNull(credential.getKey());
        printer.setPrinterId(credential.getId());
        printer.setPrinterKey(credential.getKey());

        //Check if authorized by printer user
        int count = 1;
        while (true) {
            try {
                if (count >= 6 * WAIT_TIMER) {
                    break;
                }
                System.out.println(count + ". Check if 'id' is 'authorized'.");
                AuthorizationStatus authorizationStatus = AuthCheckIdGet.get(printer);
                if (authorizationStatus.equals(AuthorizationStatus.AUTHORIZED)) {
                    System.out.println(printer.getPrinterId() + " is authorized!");
                    break;
                }
                //Sleep 10 secs
                Thread.sleep(1000 * 10);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //No timeout occured
        Assert.assertFalse(count >= 6 * WAIT_TIMER);

        //Test digest authentication
        Assert.assertTrue(AuthVerifyGet.get(printer));
    }

}

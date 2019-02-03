package de.fhl.ultimaster.api.v1.connection.history.events;

import org.junit.Assert;
import org.junit.Test;
import de.fhl.ultimaster.api.v1.history.events.HistoryEventsGet;
import de.fhl.ultimaster.api.v1.utils.TestPrinter;

public class HistoryEventsGetTest {

    @Test
    public void testHistoryEventsGet() {
        Assert.assertNotNull(HistoryEventsGet.get(TestPrinter.getInstance().getPrinter(), null, null, null));
    }

}

package de.fhl.ultimaster.gui.view.printjob;

import java.io.Serializable;
import java.util.Comparator;
import org.zkoss.zul.Listitem;
import de.fhl.ultimaster.api.v1.objects.json.PrintJobHistoric;

public class DateBeginComparator implements Comparator<Object>, Serializable {

    private static final long serialVersionUID = 3206002951642162038L;
    private boolean asc = true;

    /** Comparator for DateBegin
     * @param asc is it ascending?, else descending. */
    public DateBeginComparator(boolean asc) {
        this.asc = asc;
    }

    public int compare(Object object1, Object object2) {
        Listitem listitem1 = (Listitem) object1;
        Listitem listitem2 = (Listitem) object2;

        PrintJobHistoric printJobHistoric1 = listitem1.getValue();
        PrintJobHistoric printJobHistoric2 = listitem2.getValue();

        return printJobHistoric1.getDatetimeStarted().compareTo(printJobHistoric2.getDatetimeStarted()) * (asc ? 1 : -1);
    }

}

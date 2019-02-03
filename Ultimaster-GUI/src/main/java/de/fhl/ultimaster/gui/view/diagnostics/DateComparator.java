package de.fhl.ultimaster.gui.view.diagnostics;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Comparator;
import org.zkoss.zul.Listitem;

public class DateComparator implements Comparator<Object>, Serializable {

    private static final long serialVersionUID = 3206002951642162038L;
    private boolean asc = true;

    /** Comparator for Dates
     * @param asc is it ascending?, else descending. */
    public DateComparator(boolean asc) {
        this.asc = asc;
    }

    public int compare(Object object1, Object object2) {
        Listitem listitem1 = (Listitem) object1;
        Listitem listitem2 = (Listitem) object2;

        LocalDateTime localDateTime1 = listitem1.getValue();
        LocalDateTime localDateTime2 = listitem2.getValue();

        return localDateTime1.compareTo(localDateTime2) * (asc ? 1 : -1);
    }

}

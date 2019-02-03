package de.fhl.ultimaster.gui.view.materials;

import java.io.Serializable;
import java.util.Comparator;
import org.zkoss.zul.Listitem;

public class ColorComparator implements Comparator<Object>, Serializable {

    private static final long serialVersionUID = 3206002951642162038L;
    private boolean asc = true;

    /** Comparator for color(-strings)
     * @param asc is it ascending?, else descending. */
    public ColorComparator(boolean asc) {
        this.asc = asc;
    }

    public int compare(Object object1, Object object2) {
        Listitem listitem1 = (Listitem) object1;
        Listitem listitem2 = (Listitem) object2;

        String string1 = listitem1.getValue();
        String string2 = listitem2.getValue();

        return string1.compareTo(string2) * (asc ? 1 : -1);
    }

}

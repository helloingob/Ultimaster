package de.fhl.ultimaster.gui.utils;

import org.zkoss.zul.Box;
import org.zkoss.zul.Div;

public class ColorBox {

    public static Box get(String color, String colorCode) {
        Box box = new Box();
        box.setHflex("true");
        box.setVflex("true");
        box.setAlign("center");
        Div div = new Div();
        div.setWidth("20px");
        div.setHeight("20px");
        div.setStyle("background-color:" + colorCode + ";");
        div.setTooltiptext(color);
        box.appendChild(div);
        return box;
    }

}

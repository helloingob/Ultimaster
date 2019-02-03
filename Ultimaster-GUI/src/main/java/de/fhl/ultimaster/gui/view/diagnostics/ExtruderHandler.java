package de.fhl.ultimaster.gui.view.diagnostics;

import java.util.List;

import org.zkoss.zul.Box;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Separator;
import org.zkoss.zul.Vbox;

import de.fhl.ultimaster.api.v1.objects.json.Extruder;
import de.fhl.ultimaster.api.v1.objects.xml.FdmMaterial;
import de.fhl.ultimaster.gui.utils.ColorBox;

public class ExtruderHandler {

    public static Listitem get(List<FdmMaterial> fdmMaterials, Extruder extruder, int headNumber, int extruderNumber) {
        Listitem listitem = new Listitem();
        Listcell listcell = new Listcell();
        listitem.appendChild(listcell);

        Vbox vbox = new Vbox();
        listcell.appendChild(vbox);
        vbox.setHflex("true");
        vbox.setVflex("true");

        Label label = new Label();
        label.setStyle("font-weight:bold;");
        label.setValue("Head #" + headNumber + " - Extruder #" + extruderNumber);
        label.setHflex("true");
        vbox.appendChild(label);

        Separator separator = new Separator();
        separator.setBar(true);
        vbox.appendChild(separator);

        vbox.appendChild(getMaterialContainer(fdmMaterials, extruder.getActiveMaterial().getGuid()));
        vbox.appendChild(getAttributeContainer("Length remaining:", String.valueOf(extruder.getActiveMaterial().getLengthRemaining())));
        vbox.appendChild(getAttributeContainer("Material extruded:", String.valueOf(extruder.getHotend().getStatistics().getMaterialExtruded())));
        vbox.appendChild(getAttributeContainer("Max. temperature exposed:", String.valueOf(extruder.getHotend().getStatistics().getMaxTemperatureExposed())));
        vbox.appendChild(getAttributeContainer("Time spend hot:", String.valueOf(extruder.getHotend().getStatistics().getTimeSpentHot())));

        return listitem;
    }

    private static Hbox getMaterialContainer(List<FdmMaterial> fdmMaterials, String uuid) {
        Hbox hbox = new Hbox();
        hbox.setHflex("true");
        hbox.setAlign("center");

        Label label = new Label();
        label.setValue("Active Material:");
        label.setHflex("1");
        hbox.appendChild(label);

        Hbox hboxWrapper = new Hbox();
        hboxWrapper.setHflex("true");
        hboxWrapper.setVflex("true");
        hboxWrapper.setHflex("2");

        for (FdmMaterial fdmMaterial: fdmMaterials) {
        	if (fdmMaterial.getMetaData().getGuid().equals(uuid)) {
        		Box box = ColorBox.get(fdmMaterial.getMetaData().getName().getColor(), fdmMaterial.getMetaData().getColorCode());
        		box.setHflex("false");
        		box.setVflex("false");
        		hboxWrapper.appendChild(box);
        		hbox.appendChild(hboxWrapper);
        		
        		label = new Label();
        		label.setValue(fdmMaterial.getMetaData().getName().getBrand() + " / " + fdmMaterial.getMetaData().getName().getMaterial() + " / " + fdmMaterial.getProperties().getDiameter() + "\u2300");
        		hboxWrapper.appendChild(label);
        		break;
        	}
        }
        return hbox;
    }

    private static Hbox getAttributeContainer(String name, String value) {
        Hbox hbox = new Hbox();
        hbox.setHflex("true");
        hbox.setAlign("center");

        Label label = new Label();
        label.setValue(name);
        label.setHflex("1");
        hbox.appendChild(label);

        label = new Label();
        label.setValue(value);
        label.setHflex("2");
        hbox.appendChild(label);

        return hbox;
    }

}

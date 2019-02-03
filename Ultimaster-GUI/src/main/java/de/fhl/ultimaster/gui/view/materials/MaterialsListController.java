package de.fhl.ultimaster.gui.view.materials;

import org.pmw.tinylog.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import de.fhl.ultimaster.api.v1.materials.MaterialsGet;
import de.fhl.ultimaster.api.v1.objects.xml.FdmMaterial;
import de.fhl.ultimaster.gui.utils.ColorBox;
import de.fhl.ultimaster.shared.printer.PrinterDAO;

public class MaterialsListController extends GenericForwardComposer<Component> {

    private static final long serialVersionUID = 3854363939539449902L;
    private Listbox lbxMaterials;
    private Listheader lhdColor;
    private Textbox tbxSearch;

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
        for (FdmMaterial fdmMaterial : MaterialsGet.getSerialized(PrinterDAO.get())) {
            addListitem(fdmMaterial);
        }
        lhdColor.setSortAscending(new ColorComparator(true));
        lhdColor.setSortDescending(new ColorComparator(false));
    }

    private void addListitem(FdmMaterial fdmMaterial) {
        Listitem listitem = new Listitem();
        listitem.appendChild(new Listcell(fdmMaterial.getMetaData().getName().getBrand()));
        listitem.appendChild(new Listcell(fdmMaterial.getMetaData().getName().getMaterial()));
        Listcell listcellColor = new Listcell();
        listcellColor.appendChild(ColorBox.get(fdmMaterial.getMetaData().getName().getColor(), fdmMaterial.getMetaData().getColorCode()));
        listitem.setValue(fdmMaterial.getMetaData().getName().getColor());
        listitem.appendChild(listcellColor);
        listitem.appendChild(new Listcell(String.valueOf(fdmMaterial.getProperties().getDensity())));
        listitem.appendChild(new Listcell(String.valueOf(fdmMaterial.getProperties().getDiameter())));
        Listcell listcellDescription = new Listcell(fdmMaterial.getMetaData().getDescription());
        listcellDescription.setTooltiptext(fdmMaterial.getMetaData().getAdhesionInfo());
        listitem.appendChild(listcellDescription);
        lbxMaterials.appendChild(listitem);
    }

    public void onOK$tbxSearch() {
        for (Listitem listitem : lbxMaterials.getItems()) {
            for (Component component : listitem.getChildren()) {
                listitem.setVisible(false);
                Listcell listcell = (Listcell) component;
                if (listcell.getLabel().toLowerCase().contains(tbxSearch.getText().toLowerCase()) || tbxSearch.getText().isEmpty()) {
                    listitem.setVisible(true);
                    break;
                }
            }
        }
    }

}

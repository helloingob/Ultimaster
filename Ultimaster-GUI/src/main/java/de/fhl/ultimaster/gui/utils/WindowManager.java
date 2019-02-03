package de.fhl.ultimaster.gui.utils;

import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

public class WindowManager {

    /** Default creater for windows. 
     * @param title the title of the window. 
     * @param zulSourceFilePath the ZUL source filepath.
     * @param parameter the parameter.
     * @param maximize is maximizable? */
    public static Window createWindow(String title, String zulSourceFilePath, Map<String, ? extends Object> parameter, Boolean maximize) {
        Window win = new Window();
        win = (Window) Executions.createComponents(zulSourceFilePath, null, parameter);
        win.setPosition("center");
        win.setTitle(title);
        win.setClosable(true);
        win.setBorder("normal");
        win.setMaximizable(maximize);
        win.setSizable(maximize);
        win.doModal();
        return win;
    }

}

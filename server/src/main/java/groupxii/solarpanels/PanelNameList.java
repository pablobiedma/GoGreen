package groupxii.solarpanels;

import java.util.List;

public class PanelNameList {

    private String result = "";
    private List<Panel> panelList;

    public  List<Panel> getPanelList() {
        return panelList;
    }

    public void setPanelList(List<Panel> panelList) {
        this.panelList = panelList;
    }

    /**
     * Human-friendly String representation of PanelNameList.
     */
    public String getPanelNameList() {
        for (int i = 0; i < panelList.size(); i++) {
            result = result + panelList.get(i).getPanelname() + ", ";
        }
        result = result.substring(0, result.length() - 2);
        System.out.println("result: " + result + "\n");
        return result;
    }
}

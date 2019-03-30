package groupxii.server.controllers;

import groupxii.database.PanelEntry;
import groupxii.solarpanels.Panel;
import groupxii.solarpanels.PanelCalculations;
import groupxii.solarpanels.PanelData;
import groupxii.solarpanels.PanelNameList;
import groupxii.solarpanels.SavePanel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SolarPanelController {

    private SavePanel savePanel = new SavePanel();
    private PanelCalculations panelCalculations = new PanelCalculations();
    private PanelData panelData = new PanelData();
    private List<Panel> panelList = new ArrayList<Panel>();
    private final AtomicLong counter = new AtomicLong();

    /**
     First run this to load in the PanelDataList on the server,
     this has only to be done once the server starts.
     in the future we will load this also on the boot of the server.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/setPanelData")
    public void setPanelData() throws IOException {
        panelData.readPanelListData();
        this.panelList = panelData.getPanelList();
    }

    /**
     * This method will return the List of panels which are requested.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getPanelData")
    public List<Panel> getPanelData() {
        return panelData.getPanelList();
    }

    /**
     * This method will return the panelEntry which is saved.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getPanelEntry")
    public PanelEntry getPanelEntry() {
        return savePanel.getPanelEntry();
    }

    /**
     This method will transform the data from the panelList into one string, which then can be used
     by the client, so the choice boxes/list views in the GUI are able to show all the panel names.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/panelNameList")
    public String getNameList() {
        PanelNameList panelNameList = new PanelNameList();
        panelNameList.setPanelList(this.panelList);
        String panelNameListString = panelNameList.getPanelNameList();
        return panelNameListString;
    }

    /**
     the client can send data to the server with the right values as parameter,
     then this method will store the data in the database.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/savePanelData")
    public void savePanelData(@RequestParam(value = "paneltype",
            defaultValue = "Unknown") String paneltype, @RequestParam(value = "efficiencyrate",
            defaultValue = "0") int efficiencyrate, @RequestParam(value = "amount",
            defaultValue = "0") int amount) throws IOException {
        int reducedCO2 = getCalculatedCO2(paneltype);
        savePanel.setPanelList(this.panelList);
        savePanel.savePanelData(counter.incrementAndGet(), paneltype,
                reducedCO2 , efficiencyrate, amount);

    }

    /**
     * get method for the reduced co2.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getCalculatedCO2")
    public int getCalculatedCO2(@RequestParam(value = "paneltype",
            defaultValue = "Unknown") String paneltype) throws IOException {
        panelCalculations.setPanelList(this.panelList);

        int reducedCO2 =  panelCalculations.calculateCO2(paneltype);
        return reducedCO2;
    }
}

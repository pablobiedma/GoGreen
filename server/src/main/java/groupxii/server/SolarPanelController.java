package groupxii.server;

import groupxii.database.PanelEntry;
import groupxii.solarpanels.*;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public void getPanelData() throws IOException {
        panelData.readPanelListData();
        this.panelList = panelData.getPanelList();
    }

    /**
     This method will transform the data from the panelList into one string, which then can be used
     by the client, so the choice boxes/list views in the GUI are able to show all the panel names.
     */
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
    public PanelEntry savePanelData(@RequestParam(value = "panelA",
            defaultValue = "Unknown") String panelA, @RequestParam(value = "highefficiencyrate",
            defaultValue = "Unknown") int highefficiencyrate, @RequestParam(value = "panelB",
            defaultValue = "Unknown") String panelB, @RequestParam(value = "lowefficiencyrate",
            defaultValue = "Unknown") int lowefficiencyrate) throws IOException {
        panelCalculations.setPanelList(this.panelList);
        int reducedCO2 = panelCalculations.reducedCO2(panelB, lowefficiencyrate,
                panelCalculations.calculateCO2(panelA,highefficiencyrate));
        savePanel.setPanelList(this.panelList);
        savePanel.savePanelData(counter.incrementAndGet(), panelA,panelB,highefficiencyrate,lowefficiencyrate,reducedCO2);
        return savePanel.getPanelEntry();
    }
}
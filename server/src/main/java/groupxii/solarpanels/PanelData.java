package groupxii.solarpanels;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PanelData {
    private List<Panel> panelList =  new ArrayList<>();

    public List<Panel> getPanelList() {
        return panelList;
    }
    public void setPanelList(List<Panel> panelList) {
        this.panelList = panelList;
    }

    public void readPanelListData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(getClass().getClassLoader().getResource(
                "panelList.txt"));

        //iterates over all the elements in the JsonNode and stores the data we need
        // (panelname name, co2 emmision in grams by panel and the efficiency rate of the panel in %)
        Iterator<JsonNode> elements = rootNode.elements();
        while (elements.hasNext()) {
            JsonNode node = elements.next();
            String name = node.get("panelname").asText();
            int co2 = node.get("grams_co2_by_panel").asInt();
            int efficiencyrate = node.get("efficiencyrate_in_%").asInt();

            panelList.add(new Panel(name, co2, efficiencyrate));
            elements.next();
        }
    }
}

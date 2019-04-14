package groupxii.client.solarpanels;

import com.fasterxml.jackson.databind.ObjectMapper;
import groupxii.client.connector.SolarPanelConnector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PanelNameList {
    private List<String> panelList;

    /**
     * Asks the connector to retrieve the panel list and parses it.
     */
    public PanelNameList() {
        String json = SolarPanelConnector.retrievePanelList();
        this.parseJson(json);
    }

    public PanelNameList(String json) {
        this.parseJson(json);
    }

    private void parseJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.panelList = mapper.readValue(json,
                    mapper.getTypeFactory()
                            .constructCollectionType(List.class,
                                    String.class));
        } catch (IOException e) {
            this.panelList = new ArrayList<>();
            System.err.println(e.getMessage());
        }
    }

    public List<String> getPanelList() {
        return this.panelList;
    }
}

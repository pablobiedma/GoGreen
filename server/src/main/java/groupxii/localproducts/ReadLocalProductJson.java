package groupxii.localproducts;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadLocalProductJson {

    private List<LocalShop> localShopList = new ArrayList<>();

    public void setLocalShopList(List<LocalShop> localShopList) {
        this.localShopList = localShopList;
    }

    public List<LocalShop> getLocalShopList() {
        return localShopList;
    }

    public void readLocalProductJson() throws IOException {
        GetLocalProductsJson getLocalProductsJson = new GetLocalProductsJson();
        ObjectMapper obj = new ObjectMapper();
        JsonNode rootNode = obj.readTree(getLocalProductsJson.getLocalShopJson());

        //iterates over all the elements in the JsonNode and stores the data we need
        JsonNode results = rootNode.path("results");
        Iterator<JsonNode> elements = results.elements();
        while (elements.hasNext()) {
            JsonNode node = elements.next();
            String icon = node.get("icon").asText();
            String name = node.get("name").asText();
            boolean openingHours = node.get("open_now").asBoolean();
            int rating = node.get("rating").asInt();
            localShopList.add(new LocalShop(name, icon, rating, openingHours));
            elements.next();
        }
    }

    public String localShopToString(){
        String result = "";
        for(int i = 0; i < localShopList.size(); i++){
            result = result + "  " +  localShopList.get(i).getName() + "  " + localShopList.get(i).getIcon() + "  " + localShopList.get(i).isOpenNow() + "  " + localShopList.get(i).getRating() + ", ";
        }
        System.out.println(result);
        return result;
    }
}

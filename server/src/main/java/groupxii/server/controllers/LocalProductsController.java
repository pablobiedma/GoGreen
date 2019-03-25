package groupxii.server.controllers;

import groupxii.localproducts.LocalShop;
import groupxii.localproducts.ReadLocalProductJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LocalProductsController {

    private List<LocalShop> localShopList = new ArrayList<>();
    private ReadLocalProductJson readLocalProductJson = new ReadLocalProductJson();
    private String responseString = "";

    public void setLocalShopList(List<LocalShop> localShopList) {
        this.localShopList = localShopList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/localshops")
    public String localShopData() throws IOException {
        readLocalProductJson.readLocalProductJson();
        //setLocalShopList(readLocalProductJson.getLocalShopList());
        responseString = readLocalProductJson.localShopToString();
        return responseString;
    }
}

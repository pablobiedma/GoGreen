package groupxii.client.connector;

import groupxii.client.localproducts.GetUserLocation;

public class LocalProductsConnector {

    public static String retrieveLocalShops() {
        String resource = Connector.instance.getRequest("/localshops?location=" + GetUserLocation.getUserLocation());
        return resource;
    }
}

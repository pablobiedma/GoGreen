package groupxii.client.connector;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import groupxii.client.localproducts.GetUserLocation;

import java.io.IOException;

public class LocalProductsConnector {

    public static String retrieveLocalShops() {
        String resource = Connector.instance.getRequest("/localshops?location=" + GetUserLocation.getUserLocation());
        return resource;
    }
}

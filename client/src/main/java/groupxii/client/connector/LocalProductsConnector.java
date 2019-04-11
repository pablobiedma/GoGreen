package groupxii.client.connector;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import groupxii.client.localproducts.GetUserLocation;

import java.io.IOException;

public class LocalProductsConnector {

    public static String retrieveLocalShops() {
        String resource = null;
        try {
            resource = Connector.instance.getRequest("/localshops?location=" + GetUserLocation.getUserLocation());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeoIp2Exception e) {
            e.printStackTrace();
        }
        return resource;
    }
}

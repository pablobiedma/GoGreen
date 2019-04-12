package groupxii.client.localproducts;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import groupxii.client.connector.Connector;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class GetUserLocation {

    /**
     * gets the location of the user by using his IP adress in combination with the eth0.com API.
     * @return String with the latitude and longitude of the user.
     * @throws IOException if it is not able to connect to the api.
     * @throws GeoIp2Exception if ip cannot be turned into a location.
     */
    public static String getUserLocation() {
        String ipAddress = Connector.instance.getRequest("http://eth0.me/");
        ObjectMapper objectMapper = new ObjectMapper();
        String url = "http://api.ipstack.com/" + ipAddress + "?access_key=f8449c29422a48b1dd367afadaa10714";
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readTree(new URL("http://api.ipstack.com/" + ipAddress + "?access_key=f8449c29422a48b1dd367afadaa10714"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String longitude = rootNode.get("longitude").asText();
        String latitude = rootNode.get("latitude").asText();

        if (!longitude.equals("") && !latitude.equals("")) {
            return latitude + "," + longitude;
        } else {
            return "52.011578,4.357068";
        }

    }
}

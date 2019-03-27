package client.groupxii.localproducts;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxmind.geoip2.exception.GeoIp2Exception;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class GetUserLocation {

    private String ipAddress = "";
    private String location = "";

    public String getUserLocation() throws IOException, GeoIp2Exception {
        String ip = "";
        try {
            Scanner s = new Scanner(new URL("http://eth0.me/").openStream(), "UTF-8");
            ipAddress = s.next();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String url = "http://api.ipstack.com/" + ipAddress + "?access_key=f8449c29422a48b1dd367afadaa10714";
        JsonNode rootNode = objectMapper.readTree(new URL("http://api.ipstack.com/" + ipAddress + "?access_key=f8449c29422a48b1dd367afadaa10714"));
        String longitude = rootNode.get("longitude").asText();
        String latitude = rootNode.get("latitude").asText();

        return latitude + "," + longitude;
    }
}

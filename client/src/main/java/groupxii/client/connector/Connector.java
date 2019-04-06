package groupxii.client.connector;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.*;
import java.io.*;
//import java.util.*;


public class Connector {
    public static Connector instance = new Connector();


    public static String getRequest(String resource) {
        HttpURLConnection connection;
        try {
            URL url = new URL(Target.getHost() + resource);
            connection = (HttpURLConnection)url.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = in.readLine()) != null)
                response.append(responseLine);
            in.close();

            return response.toString();
        } catch (Exception e) {
            System.err.println("An error has occurred");
        }

        return null;
    }

}

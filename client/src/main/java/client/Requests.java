package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Resuests - Sends and interprets requests to GoGreen server.
 * @throws IOException if it recives unexpected response
 */
public class Requests {

    private String host = "localhost";
    private String port = "8080";

    /**
     * getRequest - Sends and interprets requests to GoGreen server.
     * @throws IOException if it recives unexpected response
     */
    public String getRequest(String vehicle, String button) throws IOException {
        // Url were to get the JSON data from, "transport" is now hardcoded
        // but will be a variable in the future.
        URL urlForGetRequest = new URL("http://" + host + ":" + port + "/" + button + "?" + vehicle);
        String readLine;
        // opens a http connection with the URL.
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        // sets request method and properties.
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            //Reads in all the data from the request
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            // print result
            return response.toString();
        } else {
            return "GET NOT WORKED";
        }
    }
}

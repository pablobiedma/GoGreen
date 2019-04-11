package groupxii.client.connector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Connects to the target server, sends requests and returns
 * the response, which should be a JSON string.
 */
class Connector {
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
            System.err.println("An error has occured");
        }

        return null;
    }
    /*
    public MealList getMealList() {
        String resource = "/getMealList";
        return new MealList(getRequest(resource));
    }
    */
}

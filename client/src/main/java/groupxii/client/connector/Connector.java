package groupxii.client.connector;

import groupxii.client.controllers.LoginController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Connects to the target server, sends requests and returns
 * the response, which should be a JSON string.
 */
public class Connector {
    public static Connector instance = new Connector();

    /**
     * communicates with the target server, sends request and returns response.
     * @param resource path
     * @return JSON String
     */
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
            while ((responseLine = in.readLine()) != null) {
                response.append(responseLine);
            }
            in.close();

            return response.toString();
        } catch (IOException e) {
            System.err.println("An error has occured");
        }

        return "An error has occured";
    }

    /**
     * communicates with the target server, sends POST request and returns response.
     * @param resource path
     * @return JSON String
     */
    public static String postRequest(String resource) {
        HttpURLConnection connection;
        try {
            URL url = new URL(Target.getHost() + resource);
            connection = (HttpURLConnection)url.openConnection();

            connection.setRequestMethod("POST");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                response.append(responseLine);
            }
            in.close();

            return response.toString();
        } catch (IOException e) {
            System.err.println("An error has occured");
        }

        return null;
    }

    /**
     * communicates with the target server, and updates the
     * total co2 reduction of the user in the database.
     * @param amount of CO2 the user has reduced
     * @return JSON String
     */
    public static String updateReducedCo2(String amount) {
        return postRequest("/increaseReducedCO2?Id="
                + LoginController.userId + "&ReducedCO2=" + amount);
    }
}

package groupxii.client.connector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Connects to the target server, sends requests and returns
 * the response, which should be a JSON string.
 */
public class Connector {
    public static Connector instance = new Connector();

    private static String request(String reqType, String resource, String body) {
        HttpURLConnection connection;
        try {
            URL url = new URL(Target.getHost() + resource);
            connection = (HttpURLConnection)url.openConnection();

            if (reqType.equals("POST")) {
                connection.setDoOutput(true);
            }
            connection.setRequestMethod(reqType);

            if (reqType.equals("POST")) {
                BufferedWriter requestBodyWriter = new BufferedWriter(
                        new OutputStreamWriter(
                            connection.getOutputStream()));
                requestBodyWriter.write(body);
                requestBodyWriter.close();
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                response.append(responseLine);
            }
            in.close();

            // Temporary hack
            // Since login is likely the only resource whose response
            // will have Authorization filed...
            if (resource.equals("/login")) {
                return connection.getHeaderField("Authorization");
            }

            return response.toString();
        } catch (Exception e) {
            System.err.println("An connection error has occured");
        }

        return null;
    }


    public static String getRequest(String resource) {
        return request("GET", resource, "");
    }

    public static String postRequest(String resource) {
        return request("POST", resource, "");
    }

    public static String postRequest(String resource, String body) {
        return request("POST", resource, body);
    }
}

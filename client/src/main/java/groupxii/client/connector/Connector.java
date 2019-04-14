package groupxii.client.connector;

import groupxii.client.TokenManager;
import groupxii.client.controllers.LoginController;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;

/**
 * Connects to the target server, sends requests and returns
 * the response, which should be a JSON string.
 */
public class Connector {
    public static Connector instance = new Connector();

    /**
     * Performs an HTTP request to a server.
     */
    public static String request(String reqType, String resource, String body) {
        //TODO append token as Authorization: Bearer <token>
        HttpURLConnection connection;
        try {
            connection = OpenConnection.openConnection(Target.getHost() + resource);
            if (reqType.equals("POST")) {
                connection.setDoOutput(true);
            }
        } catch (MalformedURLException e) {
            //TODO
            return null;
        } catch (IOException e) {
            //TODO
            return null;
        }

		if (TokenManager.instance.getToken() != null) {
			connection.setRequestProperty("Authorization", TokenManager.instance.getToken());
		}

        try {
            connection.setRequestMethod(reqType);
        } catch (ProtocolException e) {
            //TODO
            return null;
        }

        if (reqType.equals("POST")) {
            try {
                int length = body.length();
                connection.setFixedLengthStreamingMode(length);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.connect();
                BufferedWriter requestBodyWriter = new BufferedWriter(
                        new OutputStreamWriter(
                            connection.getOutputStream()));
                requestBodyWriter.write(body);
                requestBodyWriter.flush();
                requestBodyWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
                //TODO
            }
        }

        String response = null;
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            StringBuilder responseBuilder = new StringBuilder();
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                responseBuilder.append(responseLine);
            }
            in.close();
            response = responseBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            //TODO
        }

        // Temporary hack
        // Since login is likely the only resource whose response
        // will have Authorization filed...
        if (resource.equals("/login")) {
            return connection.getHeaderField("Authorization");
        }

        return response;
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

	//WHY THE FUCK IS THIS HERE
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

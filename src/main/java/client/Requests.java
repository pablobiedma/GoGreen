package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Requests {

    public static void GetRequest() throws IOException {
        System.out.println("How did you travel? by car, bike or public transport?");
        String userInput = userDetails();
        URL urlForGetRequest = new URL("http://localhost:8080/transport?vehicle="+userInput);
        String readLine;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }
    }

    public static String userDetails(){
        Scanner sc = new Scanner(System.in);
        String loginDetails = sc.next();
        return loginDetails;
    }

}


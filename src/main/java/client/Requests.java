package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Requests {

    public static void GetRequest() throws IOException {
        //asks user how they traveled
        System.out.println("How did you travel? by car, bike or public transport?");
        //saves user Input
        String userInput = userDetails();
        //Url were to get the JSON data from, "transport" is now hardcoded but will be a variable in the future.
        URL urlForGetRequest = new URL("http://localhost:8080/transport?vehicle="+userInput);
        String readLine;
        //opens a http connection with the URL.
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        //sets request method and properties.
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        //checks whether the connection is made successfully, the response code has to be OK otherwise it will print "GET NOT WORKED".
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
            System.out.println(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }
    }

    //method to let the user input a word and return it.
    public static String userDetails(){
        Scanner sc = new Scanner(System.in);
        String loginDetails = sc.next();
        return loginDetails;
    }

}


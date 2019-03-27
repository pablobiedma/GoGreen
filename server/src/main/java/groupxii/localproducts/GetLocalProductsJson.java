package groupxii.localproducts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetLocalProductsJson {

    private URL url;

    public String getLocalShopJson(String location){
        String localShopDataJson = "";
        try {
            url = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + location + "&radius=25000&rankby=prominence&keyword=local+produce&key=AIzaSyAx468de0kVfaSUaksLjRhjPyXdTjnuYZQ");
            localShopDataJson = readJson();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(localShopDataJson);
        return localShopDataJson;
    }

    public String readJson() throws IOException {
        String readLine = "";
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((readLine = in.readLine()) != null) {
            response.append(readLine);
        }
        in.close();
        System.out.println(response.toString());
        return response.toString();
    }
}

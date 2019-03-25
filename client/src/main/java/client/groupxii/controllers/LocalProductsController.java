package client.groupxii.controllers;

import com.maxmind.geoip2.WebServiceClient;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.InsightsResponse;
import com.maxmind.geoip2.record.Location;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.util.*;

public class LocalProductsController implements Initializable {

    @FXML
    private Text textfield = new Text();

    @FXML
    private ListView<String> localShops = new ListView();

    private List<String> listViewItems = new ArrayList<String>();
    private ObservableList<String> listViewObservable;
    private String listItemsStr = "";
    private String LongLat = "";
    private String ipAdress = "";

    public void setListViewItems(List<String> listViewItems) {
        this.listViewItems = listViewItems;
    }

    public void setIpAdress(String ipAdress){
        this.ipAdress = ipAdress;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            listItemsStr = new Scanner(new URL("http://localhost:8080/localshops").openStream(),"UTF-8").nextLine();
            WebServiceClient client = new WebServiceClient.Builder(42, "license_key").build()) {

                InetAddress ipAddress = InetAddress.getByName(ipAdress);

                InsightsResponse response = client.insights(ipAddress);
                Location locations = response.getLocation();
                System.out.println(locations.getLatitude()+locations.getLongitude());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeoIp2Exception e){
            e.printStackTrace();
        }
        listViewItems = Arrays.asList(listItemsStr.split(", "));
        listViewObservable = FXCollections.observableArrayList(listViewItems);
        System.out.println(listItemsStr);
        localShops.getItems().addAll(listViewObservable);
    }
}

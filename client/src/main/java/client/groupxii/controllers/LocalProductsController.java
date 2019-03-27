package client.groupxii.controllers;

import client.groupxii.Main;
import client.groupxii.localproducts.GetUserLocation;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class LocalProductsController implements Initializable {

    @FXML
    private Text textfield = new Text();

    @FXML
    private ListView<String> localShops = new ListView();

    @FXML


    private List<String> listViewItems = new ArrayList<String>();
    private ObservableList<String> listViewObservable;
    private GetUserLocation getUserLocation = new GetUserLocation();
    private String listItemsStr = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            listItemsStr = new Scanner(new URL("http://localhost:8080/localshops?location="+ getUserLocation.getUserLocation()).openStream(),"UTF-8").nextLine();
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

    @FXML
    public void btnBack(MouseEvent event) throws IOException{
        Main main = new Main();
        main.changeScene("Menu.fxml", event);
    }
}

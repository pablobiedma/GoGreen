package client.groupxii.controllers;

import client.groupxii.Main;
import client.groupxii.localproducts.GetUserLocation;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import java.awt.Desktop;
import java.net.URI;

public class LocalProductsController implements Initializable {

    @FXML
    private Text textfield = new Text();

    @FXML
    private ListView<String> localShops = new ListView();

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
    public void navigate(MouseEvent event) throws Exception {
        String url = localShops.getSelectionModel().getSelectedItem().substring(8 , localShops.getSelectionModel().getSelectedItem().indexOf(" - "));
        url = url.replace(' ', '+');
        Desktop.getDesktop().browse(URI.create("https://www.google.com/maps/search/?api=1&query=" + url));
    }

    @FXML
    public void boughtLocalProduct(MouseEvent event) throws Exception {

    }

    @FXML
    public void btnBack(MouseEvent event) throws IOException{
        Main main = new Main();
        main.changeScene("Menu.fxml", event);
    }
}

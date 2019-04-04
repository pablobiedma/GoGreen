package groupxii.client.controllers;

import client.groupxii.localproducts.GetUserLocation;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import groupxii.client.Main;
import groupxii.client.connector.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


public class LocalProductsController implements Initializable {

    @FXML
    private Text textfield = new Text();

    @FXML
    private ListView<String> localShops = new ListView();

    @FXML
    private ImageView mapsImage = new ImageView();

    //private List<String> listViewItems = new ArrayList<String>();
    //private ObservableList<String> listViewObservable;
    private String listItemsStr = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            GetUserLocation getUserLocation = new GetUserLocation();
            listItemsStr = Connector.instance.getLocalShops("/localshops?location="
                    + getUserLocation.getUserLocation());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeoIp2Exception e) {
            e.printStackTrace();
        }
        //listItemsStr = new Scanner(new URL("/localshops?location=" +
        // getUserLocation.getUserLocation()).openStream(),"UTF-8").nextLine();
        List<String> listViewItems = new ArrayList<>();
        listViewItems = Arrays.asList(listItemsStr.split(", "));
        ObservableList<String> listViewObservable =
                FXCollections.observableArrayList(listViewItems);
        //listViewObservable = FXCollections.observableArrayList(listViewItems);
        localShops.setItems(listViewObservable);
    }

    /**
     * gets an image of the location of the shop.
     * @param event mouse click.
     * @throws GeoIp2Exception if the location can not be initialized.
     * @throws IOException if the connection cannot be made.
     */
    @FXML
    public void getLocation(MouseEvent event) throws GeoIp2Exception, IOException {
        String url = getShopLocation();
        if (url == null) {
            textfield.setText("Please choose a shop first");
        }  else {
            //GetUserLocation getUserLocation = new GetUserLocation();
            //String location = getUserLocation.getUserLocation();
            mapsImage.setImage(new Image("https://maps.googleapis.com/maps/api/staticmap?center=" + url + "&zoom=12&size=900x150&maptype=roadmap&markers=color:red%7Clabel:Shop%7C" + url + "&key=AIzaSyBvn_zZpLGUjLJBxIUoGHgJjzo2VlZm3jg"));
        }
    }

    /**
     * opens the browser and navigates the user to the shop.
     * @param event mouse click.
     * @throws Exception if the connection to the url cannot be made.
     */
    @FXML
    public void navigate(MouseEvent event) throws Exception {
        String url = getShopLocation();
        if (localShops.getSelectionModel().getSelectedItem() == null) {
            textfield.setText("Please choose a shop first");
        } else {
            Desktop.getDesktop().browse(URI.create("https://www.google.com/maps/search/?api=1&query=" + url));
        }
    }

    /**
     * gets the adress of the shop from the listview.
     * @return String with the adress of the shop.
     */
    public String getShopLocation() {
        String locationStr = localShops.getSelectionModel().getSelectedItem();
        locationStr = locationStr.substring(locationStr.indexOf("LOCATED AT: "),
                locationStr.indexOf(" - RATING:"));
        locationStr = locationStr.replace(' ', '+').substring(0, locationStr.length() - 1);
        return locationStr;
    }

    @FXML
    public void btnBack(MouseEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("Menu.fxml", event);
    }
}

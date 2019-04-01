package client.groupxii.controllers;

import client.groupxii.Main;
import client.groupxii.localproducts.GetUserLocation;
import com.maxmind.geoip2.exception.GeoIp2Exception;
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
import java.util.*;


public class LocalProductsController implements Initializable {

    @FXML
    private Text textfield = new Text();

    @FXML
    private ListView<String> localShops = new ListView();

    @FXML
    private ImageView mapsImage = new ImageView();

    private List<String> listViewItems = new ArrayList<String>();
    private ObservableList<String> listViewObservable;
    private GetUserLocation getUserLocation = new GetUserLocation();
    private String listItemsStr = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            listItemsStr = new Scanner(new URL("http://localhost:8080/localshops?location=" + getUserLocation.getUserLocation()).openStream(),"UTF-8").nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeoIp2Exception e) {
            e.printStackTrace();
        }
        listViewItems = Arrays.asList(listItemsStr.split(", "));
        listViewObservable = FXCollections.observableArrayList(listViewItems);
        System.out.println(listItemsStr);
        localShops.setItems(listViewObservable);
    }

    public void map() throws GeoIp2Exception, IOException {
        if (localShops.getSelectionModel().getSelectedItem() == null) {
            textfield.setText("Please choose a shop first");
        }  else {
            String location = getUserLocation.getUserLocation();
            String url = localShops.getSelectionModel().getSelectedItem()
                    .substring(8 , localShops.getSelectionModel().getSelectedItem().indexOf(" - "));
            url = url.replace(' ', '+').substring(0, url.length() - 1);
            mapsImage.setImage(new Image("https://maps.googleapis.com/maps/api/staticmap?center=" + url + "&zoom=12&size=900x150&maptype=roadmap&markers=color:red%7Clabel:Shop%7C" + url + "&key=AIzaSyBvn_zZpLGUjLJBxIUoGHgJjzo2VlZm3jg"));
        }
    }


    @FXML
    public void navigate(MouseEvent event) throws Exception {
        if (localShops.getSelectionModel().getSelectedItem() == null) {
            textfield.setText("Please choose a shop first");
        } else {
            String url = localShops.getSelectionModel().getSelectedItem()
                    .substring(8, localShops.getSelectionModel().getSelectedItem().indexOf(" - "));
            url = url.replace(' ', '+');
            Desktop.getDesktop().browse(URI.create("https://www.google.com/maps/search/?api=1&query=" + url));
        }
    }

    @FXML
    public void getLocation(MouseEvent event) throws Exception {
        try {
            map();
        } catch (GeoIp2Exception e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void btnBack(MouseEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("Menu.fxml", event);
    }
}

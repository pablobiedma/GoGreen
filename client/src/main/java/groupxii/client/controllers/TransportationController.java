package groupxii.client.controllers;

import groupxii.client.transportation.VehicleNameList;
import groupxii.client.transportation.UsedTransportList;
import groupxii.client.transportation.ReducedCo2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
//import javafx.scene.text.Text;
import groupxii.client.transportation.UsedTransportList;
import groupxii.client.connector.TransportConnector;

import java.net.URL;
import java.util.ResourceBundle;


public class TransportationController implements Initializable {

    /*
    @FXML
    private Button btnCalculateTransport = new Button();

    @FXML
    private Button btnSafeTransport = new Button();
    */

    @FXML
    private ChoiceBox<String> cb = new ChoiceBox();

    @FXML
    private ChoiceBox<String> cb1 = new ChoiceBox();

    @FXML
    private Text reducedCo2Text = new Text();

    @FXML
    private Slider slider = new Slider();

    @FXML
    private Slider slider1 = new Slider();

    @FXML
    private Text savedCo2 = new Text();

    @FXML
    private ListView<String> usedTransportListView = new ListView();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        VehicleNameList vehicleNameList = new VehicleNameList();
        ObservableList<String> listObservable =
                FXCollections.observableArrayList(vehicleNameList.getVehicleNameList());
        cb1.getItems().addAll(listObservable);
        cb.getItems().addAll(listObservable);
        updateListView();
    }

    /**
     * Updates the listview with all the items from the database.
     */
    @FXML
    public void updateListView() {
        ObservableList<String> usedTransportObservableList
                = FXCollections.observableArrayList(UsedTransportList.getUsedTransportList());
        usedTransportListView.setItems(usedTransportObservableList);
    }

    @FXML
    public void calculateTransport(MouseEvent event) {
        String goodTransportName = cb.getValue();
        int goodConsumption = (int) slider.getValue();
        String badTransportName = cb1.getValue();
        int badConsumption = (int) slider1.getValue();

        String result = ReducedCo2.getReducedCo2(goodTransportName,
                                                 goodConsumption,
                                                 badTransportName,
                                                 badConsumption);

        reducedCo2Text.setText("This will reduce " + result + "grams of CO2");
    }

    /**
     * Calculates the co2 reduced emmision when the user clicks the calculate button.
     * it also calculates the amount of points the user earned.
     *
     * @param event mouse click
     * @throws Exception throws exception when something went wrong
     */
    @FXML
    public void saveTransport(MouseEvent event) throws Exception {
        String goodTransportName = cb.getValue();
        int goodConsumption = (int) slider.getValue();
        String badTransportName = cb1.getValue();
        int badConsumption = (int) slider1.getValue();

        TransportConnector.commitTransport(goodTransportName,
                                           badTransportName,
                                           goodConsumption,
                                           badConsumption);
        reducedCo2Text.setText("Enjoy your ride :-)");
        updateListView();
    }
}

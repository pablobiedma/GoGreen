package groupxii.client.controllers;

import groupxii.client.transportation.VehicleNameList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
//import javafx.scene.text.Text;
import groupxii.client.transportation.UsedTransportList;
import groupxii.client.connector.TransportConnector;
import groupxii.client.transportation.ReducedCO2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;


public class TransportationController implements Initializable {

    @FXML
    private Button btnCalculateTransport = new Button();

    @FXML
    private Button btnSafeTransport = new Button();

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

    //    @FXML
//    private ListView<String> usedTransportListView = new ListView();
    UsedTransportList usedTransportList = new UsedTransportList();
//    private String A = "car";
//    private String B = "bike";
//    private String C = "taxi";
//    private String D = "metro";
//    private String E = "train";
//    private String F = "airplane";
//    private String P = "Diesel";
//    private String Q = "Petrol";
//    private String R = "Electric_Wires";
//    private String S = "none";
//    private String goodTransportName = "";
//    private String badTransportName = "";
//    private String goodfuel = "";
//    private String badfuel = "";
    //private String host = "http://localhost:8080/";
//    private String transportNameListStr = "";
//    private String usedTransportListStr = "";
//    private SafeVehicle safeTransport = new SafeVehicle();
//   private List<String> usedTransportListViewItems = new ArrayList<String>();
//    private List<String> l = new ArrayList<>();
//    private List<String> l2 = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        try {
//            transportNameListStr = new Scanner(new URL(host + "TransportNameList").openStream(),
//                    "UTF-8").nextLine();
//            usedTransportListStr = new Scanner(new URL(host + "usedTransportList").openStream(),
//                    "UTF-8").nextLine();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(transportNameListStr);
//        System.out.println("TEST");
//
//        usedTransportListViewItems = Arrays.asList(usedTransportListStr.split(" - "));
//        ObservableList<String> usedTransportObservable =
//                FXCollections.observableArrayList(usedTransportListViewItems);
//        usedTransportListView.setItems(usedTransportObservable);
//        List<String> items = Arrays.asList(transportNameListStr.split(", "));
//        ObservableList<String> listObservable = FXCollections.observableArrayList(items);
//        l.add(A);
//        l.add(B);
//        l.add(C);
//        l.add(D);
//        l.add(E);
//        l.add(F);
//        l2.add(P);
//        l2.add(Q);
//        l2.add(R);
//        l2.add(S);
//        cb.getItems().addAll(listObservable);
//        cb.getItems().addAll(l);
//        cb1.getItems().addAll(listObservable);
//        cb1.getItems().addAll(l);
//        cb3.getItems().addAll(listObservable);
//        cb3.getItems().addAll(l2);
//        cb4.getItems().addAll(listObservable);
//        cb4.getItems().addAll(l2);
//        updateListView();
        VehicleNameList vehicleNameList = new VehicleNameList();
        ObservableList<String> listObservable = FXCollections.observableArrayList(vehicleNameList.getVehicleNameList());
        cb1.getItems().addAll(listObservable);
        cb.getItems().addAll(listObservable);
        updateListView();
    }

    /**
     * updates the listview with all the items from the database.
     */
    @FXML
    public void updateListView() {
        usedTransportList.setUsedTransportList();
        ObservableList<String> usedTransportObservableList = FXCollections.observableArrayList(usedTransportList.getEatenMealList());
        usedTransportListView.setItems(usedTransportObservableList);


//        try {
//            usedTransportListStr = new Scanner(new URL(host + "usedTransportList").openStream(),
//                    "UTF-8").nextLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        usedTransportListViewItems = Arrays.asList(usedTransportListStr.split(" - "));
//        ObservableList<String> usedTransportObservable =
//                FXCollections.observableArrayList(usedTransportListViewItems);
//        usedTransportListView.setItems(usedTransportObservable);
    }

    //TODO
    @FXML
    public void calculateTransport(MouseEvent event) {

    }

    /**
     * Calculates the co2 reduced emmision when the user clicks the calculate button.
     * it also calculates the amount of points the user earned.
     *
     * @param event mouse click
     * @throws Exception throws exception when something went wrong
     */
    @FXML
    public void safeTransport(MouseEvent event) throws Exception {
//        badTransportName = cb1.getValue();
//        goodTransportName = cb.getValue();
//        goodfuel = cb3.getValue();
//        badfuel = cb4.getValue();
//        int goodConsumption = (int) slider.getValue();
//        int badConsumption = (int) slider1.getValue();
//        safeTransport.safeVehicle(goodTransportName, badTransportName,goodfuel,
//                badfuel,goodConsumption , badConsumption);
        String goodTransportName = cb.getValue();
        int goodConsumption = (int) slider.getValue();
        String badTransportName = cb1.getValue();
        int badConsumption = (int) slider1.getValue();


        String result = TransportConnector.calculateCO2Reduction(goodTransportName, badTransportName, goodConsumption, badConsumption);
        //TODO update contoller to display result
        updateListView();
    }
}

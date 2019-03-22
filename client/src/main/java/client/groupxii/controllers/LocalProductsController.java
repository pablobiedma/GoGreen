package client.groupxii.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.io.IOException;
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

    public void setListViewItems(List<String> listViewItems) {
        this.listViewItems = listViewItems;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            listItemsStr = new Scanner(new URL("http://localhost:8080/localshops").openStream(),"UTF-8").nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        listViewItems = Arrays.asList(listItemsStr.split(", "));
        listViewObservable = FXCollections.observableArrayList(listViewItems);
        System.out.println(listItemsStr);
        localShops.getItems().addAll(listViewObservable);

    }
}

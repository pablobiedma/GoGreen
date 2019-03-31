package client.groupxii.controllers;

import client.groupxii.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class LeaderboardController implements Initializable {

    private String overallListStr = "";
    private String friendListStr = "";
    private String host = "http://localhost:8080/";
    //Should be the userId that is assigned to the user when he/she registers
    private String userId = "1";
    private Button button = new Button("ADD FRIEND");

    @FXML
    private ListView<HBoxCell> overallLeaderboard = new ListView();

    @FXML
    private ListView<HBoxCell> friendsLeaderboard = new ListView();

    public static class HBoxCell extends HBox {
        Label label = new Label();
        Button button = new Button();

        HBoxCell(String labelText, String buttonText) {
            super();

            label.setText(labelText);
            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);

            button.setText(buttonText);

            this.getChildren().addAll(label, button);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            overallListStr = new Scanner(new URL(host + "Leaderboard").openStream(),
                    "UTF-8").nextLine();
            friendListStr = new Scanner(new URL(host + "getFriends?Id=" + userId).openStream(),
                    "UTF-8").nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> overallLeaderboardList = Arrays.asList(overallListStr.split(", "));
        List<HBoxCell> overallList = new ArrayList<>();
        for (int i = 0; i < overallLeaderboardList.size(); i++){
            overallList.add(new HBoxCell(overallLeaderboardList.get(i), "ADD FRIEND"));
        }
        ObservableList<HBoxCell> overallLeaderboardObservableList = FXCollections.observableArrayList(list);
        overallLeaderboard.setItems(overallLeaderboardObservableList);

        List<String> friendsLeaderboardList = Arrays.asList(friendListStr.split(", "));
        List<HBoxCell> list = new ArrayList<>();
        for (int i = 0; i < friendsLeaderboardList.size(); i++){
            list.add(new HBoxCell(friendsLeaderboardList.get(i), "UNFOLLOW"));
        }
        ObservableList<HBoxCell> friendsLeaderboardObservableList = FXCollections.observableArrayList(list);
        friendsLeaderboard.setItems(friendsLeaderboardObservableList);
    }

    @FXML
    public void btnBack(MouseEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("Menu.fxml", event);
    }
}

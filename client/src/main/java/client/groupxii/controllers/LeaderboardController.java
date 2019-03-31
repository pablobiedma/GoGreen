package client.groupxii.controllers;

import client.groupxii.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LeaderboardController implements Initializable {

    private String overallListStr = "";
    private String friendListStr = "";
    private String host = "http://localhost:8080/";
    //Should be the userId that is assigned to the user when he/she registers
    private String userId = "1";

    @FXML
    private ListView<String> overallLeaderboard = new ListView();

    @FXML
    private ListView<String> friendsLeaderboard = new ListView();

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
        List<String> overalLeaderboardList = Arrays.asList(overallListStr.split(", "));
        ObservableList<String> overalLeaderboardObservableList = FXCollections.observableArrayList(overalLeaderboardList);
        overallLeaderboard.setItems(overalLeaderboardObservableList);
        List<String> friendsLeaderboardList = Arrays.asList(friendListStr.split(", "));
        ObservableList<String> friendsLeaderboardObservableList = FXCollections.observableArrayList(friendsLeaderboardList);
        friendsLeaderboard.setItems(friendsLeaderboardObservableList);
    }

    @FXML
    public void btnBack(MouseEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("Menu.fxml", event);
    }
}

package client.groupxii.controllers;

import client.groupxii.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class LeaderboardController {

    @FXML
    private ListView<String> overallLeaderboard = new ListView();

    @FXML
    private ListView<String> friendsLeaderboard = new ListView();

    @FXML
    public void btnBack(MouseEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("Menu.fxml", event);
    }
}

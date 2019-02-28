package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

public class Controller {

    //this is the text what will be shown as a response in the program
    @FXML
    private Text textFlow;

    //When the user clicks on the "Car" button, the event calls this method and this will
    // show the response of the "getRequest" method in the "Requests" class in the program.
    @FXML
    protected void carAction(ActionEvent event) throws IOException {
        textFlow.setText(Requests.getRequest("car"));
    }

    @FXML
    protected void bikeAction(ActionEvent event) throws IOException {
        textFlow.setText(Requests.getRequest("bike"));
    }

    @FXML
    protected void pubTransAction(ActionEvent event) throws IOException {
        textFlow.setText(Requests.getRequest("PTAction"));
    }
}

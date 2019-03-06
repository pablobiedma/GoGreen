package client.group12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

public class Controller {

    //this is the text what will be shown as a response in the program
    @FXML
    private Text textFlow;
    private Requests request = new Requests();
    //When the user clicks on the "Car" button, the event calls this method and this will
    // show the response of the "getRequest" method in the "client.group12.Requests" class in the program.
    @FXML
    protected void carAction(ActionEvent event) throws IOException {
        textFlow.setText(request.getRequest("vehicle=car", "transport"));
    }

    @FXML
    protected void bikeAction(ActionEvent event) throws IOException {
        textFlow.setText(request.getRequest("vehicle=bike", "transport"));
    }

    @FXML
    protected void pubTransAction(ActionEvent event) throws IOException {
        textFlow.setText(request.getRequest("vehicle=PTAction", "transport"));
    }
}

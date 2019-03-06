package client.group12;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class RequestsTest {

    Requests request = new Requests();

    @Test
    public void carRequestTest() throws IOException {
        assertTrue(request.getRequest("vehicle=car", "transport").contains("At least use public transport!")); }

    @Test
    public void publicTransportRequestTest() throws IOException {
        assertTrue(request.getRequest("vehicle=public_transport", "transport").contains("Use a bike instead")); }

    @Test
    public void bikeRequestTest() throws IOException {
        assertTrue(request.getRequest("vehicle=bike", "transport").contains("Good job!")); }
}

package client;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class RequestsTest {

    @Test
    public void carRequestTest() throws IOException {
        assertTrue(Requests.getRequest("car").contains("At least use public transport!")); }

    @Test
    public void publicTransportRequestTest() throws IOException {
        assertTrue(Requests.getRequest("public_transport").contains("Use a bike instead")); }

    @Test
    public void bikeRequestTest() throws IOException {
        assertTrue(Requests.getRequest("bike").contains("Good job!")); }
}

package client;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import server.*;

import java.io.IOException;

import static org.junit.Assert.*;

public class RequestsTest {

    @BeforeClass
    public static void StartServer1(){
        String[] arguments = new String[] {"123"};
        server.ServerApplication.main(arguments);
    }

    @Test
    public void carRequestTest() throws IOException {
        assertTrue(Requests.GetRequest("car").contains("At least use public transport!")); }

    @Test
    public void publicTransportRequestTest() throws IOException {
        assertTrue(Requests.GetRequest("public_transport").contains("Use a bike instead")); }

    @Test
    public void bikeRequestTest() throws IOException {
        assertTrue(Requests.GetRequest("bike").contains("Good job!")); }
}
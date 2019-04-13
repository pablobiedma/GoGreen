package groupxii.client.controllers;

import org.junit.Test;

import static org.junit.Assert.*;

public class LocalProductsControllerTest {

    @Test
    public void getShopLocationTest() {
        LocalProductsController localProductsController = new LocalProductsController();
        assertTrue(localProductsController.getShopLocation().contains("LOCATED AT: "));
    }
}
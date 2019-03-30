package groupxii.database;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class VehicleEntryTest {
    @Test
    public void getUserId() {
        VehicleEntry ve = new VehicleEntry(1, "bike","car",40,"Petrol","Diesel",4,8);
        assertEquals(1, ve.getUserId());
    }
    @Test
    public void getGoodVehicleType() {
        VehicleEntry ve = new VehicleEntry(1337, "bike","car",40,"Petrol","Diesel",4,8);
        assertEquals("bike", ve.getGoodVehicleType());
    }
    @Test
    public void getBadVehicleType() {
        VehicleEntry ve = new VehicleEntry(1337, "bike","car",40,"Petrol","Diesel",4,8);
        assertEquals("car", ve.getBadvehicleType());
    }
    @Test
    public void getGoodFuel() {
        VehicleEntry ve = new VehicleEntry(1337, "bike","car",40,"Petrol","Diesel",4,8);
        assertEquals("Petrol", ve.getGoodFuel());
    }
    @Test
    public void getBadFuel() {
        VehicleEntry ve = new VehicleEntry(1337, "bike","car",40,"Petrol","Diesel",4,8);
        assertEquals("Diesel", ve.getBadfuel());
    }
    @Test
    public void getco2() {
        VehicleEntry ve = new VehicleEntry(1337, "bike","car",40,"Petrol","Diesel",4,8);
        assertEquals(40, ve.getCo2());
    }
    @Test
    public void getGoodAvgConsumption() {
        VehicleEntry ve = new VehicleEntry(1337, "bike","car",40,"Petrol","Diesel",4,8);
        assertEquals(4, ve.getGoodAvgconsumption());
    }
    @Test
    public void getBadAvgConsumption() {
        VehicleEntry ve = new VehicleEntry(1337, "bike","car",40,"Petrol","Diesel",4,8);
        assertEquals(8, ve.getBadavgconsumption());
    }
    @Test
    public void setUserid() {
        VehicleEntry ve = new VehicleEntry(1337, "bike","car",40,"Petrol","Diesel",4,8);
        VehicleEntry ve2 = new VehicleEntry(1, "bike","car",40,"Petrol","Diesel",4,8);
        ve2.setUserId(1337);
        assertEquals(ve.getUserId(),ve2.getUserId());
    }
    @Test
    public void setGoodVehicletype() {
        VehicleEntry ve = new VehicleEntry(1337, "bike","car",40,"Petrol","Diesel",4,8);
        VehicleEntry ve2 = new VehicleEntry(1, "metro","car",40,"Petrol","Diesel",4,8);
        ve2.setGoodVehicleType("bike");
        assertEquals(ve.getGoodVehicleType(),ve2.getGoodVehicleType());
    }
    @Test
    public void setBadVehicletype() {
        VehicleEntry ve = new VehicleEntry(1337, "bike","audi",40,"Petrol","Diesel",4,8);
        VehicleEntry ve2 = new VehicleEntry(1, "metro","Truck",40,"Petrol","Diesel",4,8);
        ve2.setBadvehicleType("audi");
        assertEquals(ve.getBadvehicleType(),ve2.getBadvehicleType());
    }
    @Test
    public void setco2() {
        VehicleEntry ve = new VehicleEntry(1337, "bike","audi",40,"Petrol","Diesel",4,8);
        VehicleEntry ve2 = new VehicleEntry(1, "metro","Truck",50,"Petrol","Diesel",4,8);
        ve2.setCo2(40);
        assertEquals(ve.getCo2(),ve2.getCo2());
    }

    @Test
    public void setGoodFuel() {
        VehicleEntry ve = new VehicleEntry(1337, "bike","audi",40,"Petrol","Diesel",4,8);
        VehicleEntry ve2 = new VehicleEntry(1, "metro","Truck",50,"none","Diesel",4,8);
        ve2.setGoodFuel("Petrol");
        assertEquals(ve.getGoodFuel(),ve2.getGoodFuel());
    }
    @Test
    public void setBadFuel() {
        VehicleEntry ve = new VehicleEntry(1337, "bike","audi",40,"Petrol","Diesel",4,8);
        VehicleEntry ve2 = new VehicleEntry(1, "metro","Truck",50,"none","none",4,8);
        ve2.setBadfuel("Diesel");
        assertEquals(ve.getBadfuel(),ve2.getBadfuel());
    }
    @Test
    public void setGoodAvgConsumption() {
        VehicleEntry ve = new VehicleEntry(1337, "bike","audi",40,"Petrol","Diesel",4,8);
        VehicleEntry ve2 = new VehicleEntry(1, "metro","Truck",50,"none","none",5,8);
        ve2.setGoodAvgconsumption(4);
        assertEquals(ve.getGoodAvgconsumption(),ve2.getGoodAvgconsumption());
    }
    @Test
    public void setBadAvgConsumption() {
        VehicleEntry ve = new VehicleEntry(1337, "bike","audi",40,"Petrol","Diesel",4,8);
        VehicleEntry ve2 = new VehicleEntry(1, "metro","Truck",50,"none","none",4,9);
        ve2.setBadavgconsumption(8);
        assertEquals(ve.getBadavgconsumption(),ve2.getBadavgconsumption());
    }
}

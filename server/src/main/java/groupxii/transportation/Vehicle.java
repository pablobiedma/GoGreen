package groupxii.transportation;

public class Vehicle {

    private String vehiclename;
    private int co2;
    private String fuel;
    private int avgconsumption;

    /**
     * This is the constructor of a Vehicle
     * @param vehiclename
     * @param co2 in grams/kilometres
     * @param fuel
     * @param avgconsumption in litres/100kilometres
     */
    public Vehicle(String vehiclename, int co2, String fuel, int avgconsumption) {
        this.vehiclename = vehiclename;
        this.co2 = co2;
        this.fuel = fuel;
        this.avgconsumption = avgconsumption;
    }

    public String getVehiclename() {
        return vehiclename;
    }

    public int getCo2() {
        return co2;
    }

    public String getFuel() {
        return fuel;
    }

    public void setVehiclename(String vehiclename) {
        this.vehiclename = vehiclename;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getAvgconsumption() {
        return avgconsumption;
    }

    public void setAvgconsumption(int avgconsumption) {
        this.avgconsumption = avgconsumption;
    }
}

package groupxii.transportation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehicleCalculations {

    private String vehicle;
    private int co2;
    private String fuel;
    private int avgconsumption;
    private List<Vehicle> vehicles = new ArrayList<>();
    private int calculatedco2;
    private int reducedco2;

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Here we calculate the amount of co2 emission by hard.
     * @param chosenVehicle
     * @param chosenFuel
     * @param chosenConsumption
     * @return
     * @throws IOException
     */
    public int calculateCO2(String chosenVehicle, String chosenFuel, int chosenConsumption)
            throws IOException {
        for (int i = 0;i<vehicles.size(); i++) {
            if (chosenVehicle.equals(vehicles.get(i).getVehiclename())) {
                this.vehicle = vehicles.get(i).getVehiclename();
                this.co2 = vehicles.get(i).getCo2();
                this.fuel = vehicles.get(i).getFuel();
                this.avgconsumption = vehicles.get(i).getAvgconsumption();

                if (chosenFuel.equals("Diesel")) {
                    calculatedco2 = (chosenConsumption/100) * 2640;
                }
                if (chosenFuel.equals("Petrol")) {
                    calculatedco2 = (chosenConsumption/100) * 2392;
                }
                if (chosenFuel.equals("LPG")) {
                    calculatedco2 = (chosenConsumption/100) * 1665;
                }
                if (chosenFuel.equals("Electric_wires")) {
                    double co2perliter = co2/avgconsumption;
                    calculatedco2 = (int) co2perliter * chosenConsumption;
                }
                else {
                    calculatedco2 = 0;
                }
            }
        }
        return calculatedco2;
    }

    /**
     * This is where we will calculate the difference of co2 emission between car and the chosen public transport.
     * @param car
     * @param chosenFuel
     * @param chosenConsumption
     * @param publictransport
     * @return
     * @throws IOException
     */
    public int reducedCO2(String car, String chosenFuel, int chosenConsumption, int publictransport)
            throws IOException {
        this.reducedco2 = calculateCO2(car,chosenFuel,chosenConsumption) - publictransport;
        return this.reducedco2;
    }

    public int CalculatePoints() {
        return this.reducedco2 * 5;
    }
}

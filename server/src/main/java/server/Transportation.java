package server.group12;

/* Transportation - dummy class that suggest the user what
 * transportation method to use
 * */
public class Transportation {
	private final long id;
	private final String vehicleSuggestion;

	public long getId() {
		return this.id;
	}
	public String getVehicleSuggestion() {
		return this.vehicleSuggestion;
	}

	private String suggestVehicle(String vehicleType) {
        if (vehicleType.equals("car"))
            return "At least use public transport!";
        else if (vehicleType.equals("public_transport"))
            return "Use a bike instead";
        else if (vehicleType.equals("bike"))
            return "Good job!";

		return "Just use a bike";
    }

	public Transportation(long id, String vehicleType) {
		this.id = id;
		this.vehicleSuggestion = new String(suggestVehicle(vehicleType));
	}
}

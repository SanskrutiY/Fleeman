package enums;

public enum VehicleType {
	SEDAN("Sedan"),
	HATCHBACK("Hatchback"),
	SUV("SUV");
	
	private String vehicleType;
	
	VehicleType(String value) {
		this.vehicleType = value;
	}
	
	public String stringValue() {
		return this.vehicleType;
	}
}

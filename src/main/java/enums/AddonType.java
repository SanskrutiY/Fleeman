package enums;

public enum AddonType {
    FIRST_AID_KIT("First aid kit"),
    GPS_NAVIGATION("GPS Navigation"),
    CAMPING_KIT("Camping kit"),
    CHILD_SEATS("Child seats");

	private String addonType;
	
    AddonType(String value) {
        this.addonType = value;
    }
    
    public String stringValue() {
    	return this.addonType;
    }
}
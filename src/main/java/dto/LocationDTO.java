package dto;

import lombok.Data;

@Data
public class LocationDTO {
    private int hubId;
    private String hubAddress;
    private String city;
    private String state;
    private String airportCode;
}
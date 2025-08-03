package service;

import dto.LocationDTO;
import java.util.List;

public interface LocationService {
    List<LocationDTO> getAllHubs();
    LocationDTO getHubByName(int hubId);	// to get the hubs based of its address
    List<LocationDTO> getHubsByAirportCode(String airportCode);
    LocationDTO createHub(LocationDTO dto);
    LocationDTO updateHub(int hubId, LocationDTO dto);
    void deleteHub(int hubId);
}

package controller;

import dto.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<LocationDTO> getAllHubs() {
        return locationService.getAllHubs();
    }

    @GetMapping("/{hubId}")
    public LocationDTO getHubById(@PathVariable int hubId) {
        return locationService.getHubByName(hubId);
    }

    @GetMapping("/airport/{airportCode}")
    public List<LocationDTO> getHubsByAirportCode(@PathVariable String airportCode) {
        return locationService.getHubsByAirportCode(airportCode);
    }

    @PostMapping
    public LocationDTO createHub(@RequestBody LocationDTO dto) {
        return locationService.createHub(dto);
    }

    @PutMapping("/{hubId}")
    public LocationDTO updateHub(@PathVariable int hubId, @RequestBody LocationDTO dto) {
        return locationService.updateHub(hubId, dto);
    }

    @DeleteMapping("/{hubId}")
    public void deleteHub(@PathVariable int hubId) {
        locationService.deleteHub(hubId);
    }
}

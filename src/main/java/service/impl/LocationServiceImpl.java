package service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.LocationDTO;
import entity.Location;
import mapper.Mapper;
import repository.LocationRepository;
import service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
    private LocationRepository locationRepo;
	
	@Override
	public List<LocationDTO> getAllHubs() {
		return locationRepo.findAll()
                .stream()
                .map(Mapper::mapToLocationDTO)
                .collect(Collectors.toList());
	}

	@Override
	public LocationDTO getHubByName(int hubId) {
		return locationRepo.findByHubId(hubId)
	            .map(Mapper::mapToLocationDTO)
	            .orElse(null);
	}

	@Override
	public List<LocationDTO> getHubsByAirportCode(String airportCode) {
	    return locationRepo.findByAirportCode(airportCode)
	            .stream()
	            .map(Mapper::mapToLocationDTO)
	            .collect(Collectors.toList());
	}

	@Override
	public LocationDTO createHub(LocationDTO dto) {
		Location location = Mapper.mapToLocationEntity(dto);
        Location saved = locationRepo.save(location);
        return Mapper.mapToLocationDTO(saved);
	}

	@Override
	public LocationDTO updateHub(int hubId, LocationDTO dto) {
		if (!locationRepo.existsById(hubId)) return null;
        Location updated = Mapper.mapToLocationEntity(dto);
        updated.setHubId(hubId);
        updated = locationRepo.save(updated);
        return Mapper.mapToLocationDTO(updated);
	}

	@Override
	public void deleteHub(int hubId) {
		locationRepo.deleteById(hubId);
	}

}

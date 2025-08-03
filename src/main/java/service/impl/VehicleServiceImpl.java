package service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dto.VehicleDTO;
import entity.Vehicle;
import mapper.Mapper;
import repository.VehicleRepository;
import service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepo;
	
	@Override
	public List<VehicleDTO> getAllVehicles() {
		List<Vehicle> vehicleList = vehicleRepo.findAll();
		List<VehicleDTO> vehicleDtoList = new ArrayList<>();
		for(Vehicle vehicles : vehicleList) {
			VehicleDTO vehDto = Mapper.mapToVehicleDTO(vehicles);
			vehicleDtoList.add(vehDto);
		}
		return vehicleDtoList;
		
//		return vehicleRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public VehicleDTO getVehicleById(int vehicle_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleDTO updateVehicle(int vehicle_id, VehicleDTO vehicleDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVehicle(int vehicle_id) {
		// TODO Auto-generated method stub
		
	}
	
}

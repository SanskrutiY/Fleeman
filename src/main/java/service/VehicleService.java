package service;

import java.util.List;
import dto.VehicleDTO;

public interface VehicleService {
	List<VehicleDTO> getAllVehicles();
    VehicleDTO getVehicleById(int vehicle_id);
//	VehicleDTO getVehicleByModel(String model);
    VehicleDTO createVehicle(VehicleDTO vehicleDTO);
    VehicleDTO updateVehicle(int vehicle_id, VehicleDTO vehicleDTO);
    void deleteVehicle(int vehicle_id);
}

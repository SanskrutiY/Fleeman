package service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.FuelLogDTO;
import mapper.Mapper;
import repository.FuelLogRepository;
import service.FuelLogService;
import entity.FuelLogs;
import entity.Vehicle;

@Service
public class FuelLogServiceImpl implements FuelLogService {

    @Autowired
    private FuelLogRepository fuelLogRepo;
	
	@Override
	public List<FuelLogDTO> getAllFuelLogs() {
		 return fuelLogRepo.findAll()
	                .stream()
	                .map(Mapper::mapToFuelLogDTO)
	                .collect(Collectors.toList());
	}

	@Override
	public FuelLogDTO getFuelLogByVehicleId(int vehicle_id) {
		// for this I need VehicleAssignment always guaranteed to exist
		return null;
//		 return fuelLogRepo.findAll().stream()
//	                .filter(log -> log.getAssignment() != null
//	                        && log.getAssignment().getVehicle() != null
//	                        && log.getAssignment().getVehicle().getVehicleId() == vehicle_id)
//	                .findFirst()
//	                .map(Mapper::mapToFuelLogDTO)
//	                .orElse(null);
	}

	@Override
	public List<FuelLogDTO> getFuelLogsByAssignmentId(int assignmentId) {
		return null;
//		return fuelLogRepo.findByAssignmentAssignmentId(assignmentId)
//                .stream()
//                .map(Mapper::mapToFuelLogDTO)
//                .collect(Collectors.toList());
	}

	@Override
	public FuelLogDTO createFuelLog(FuelLogDTO dto) {
		FuelLogs fuelLog = Mapper.mapToFuelLogEntity(dto);
        FuelLogs saved = fuelLogRepo.save(fuelLog);
        return Mapper.mapToFuelLogDTO(saved);
	}

	@Override
	public FuelLogDTO updateFuelLog(int id, FuelLogDTO dto) {
		if (!fuelLogRepo.existsById(id)) {
            return null;
        }
        FuelLogs updatedEntity = Mapper.mapToFuelLogEntity(dto);
//        updatedEntity.setFuel_id(id);
        FuelLogs updated = fuelLogRepo.save(updatedEntity);
        return Mapper.mapToFuelLogDTO(updated);
	}

	@Override
	public void deleteFuelLog(int id) {
		fuelLogRepo.deleteById(id);		
	}

}

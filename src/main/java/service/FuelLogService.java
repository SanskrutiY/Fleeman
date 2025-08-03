package service;

import java.util.List;

import dto.FuelLogDTO;

public interface FuelLogService {
	List<FuelLogDTO> getAllFuelLogs();
    FuelLogDTO getFuelLogByVehicleId(int vehicle_id);
    List<FuelLogDTO> getFuelLogsByAssignmentId(int assignmentId);
    FuelLogDTO createFuelLog(FuelLogDTO dto);
    FuelLogDTO updateFuelLog(int id, FuelLogDTO dto);
    void deleteFuelLog(int id);
}

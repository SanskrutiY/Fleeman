package service;

import dto.VehicleAssignmentDTO;
import java.util.List;

public interface VehicleAssignmentService {
    List<VehicleAssignmentDTO> getAllAssignments();
    VehicleAssignmentDTO getAssignmentById(int id);
//    List<VehicleAssignmentDTO> getAssignmentsByCustomerId(int customerId);
//    VehicleAssignmentDTO createAssignment(VehicleAssignmentDTO dto);
//    VehicleAssignmentDTO updateAssignment(int id, VehicleAssignmentDTO dto);
    void deleteAssignment(int id);
}

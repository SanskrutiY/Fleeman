package controller;

import dto.VehicleAssignmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.VehicleAssignmentService;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class VehicleAssignmentController {

    @Autowired
    private VehicleAssignmentService service;

    // ✅ Get all vehicle assignments
    @GetMapping
    public List<VehicleAssignmentDTO> getAllAssignments() {
        return service.getAllAssignments();
    }

    // ✅ Get assignment by ID
    @GetMapping("/{id}")
    public VehicleAssignmentDTO getAssignmentById(@PathVariable int id) {
        return service.getAssignmentById(id);
    }

    // ✅ Get assignments by customer ID
    @GetMapping("/customer/{custId}")
    public List<VehicleAssignmentDTO> getAssignmentsByCustomer(@PathVariable int custId) {
        return service.getAssignmentsByCustomerId(custId);
    }

    // ✅ Create new assignment
    @PostMapping
    public VehicleAssignmentDTO createAssignment(@RequestBody VehicleAssignmentDTO dto) {
        return service.createAssignment(dto);
    }

    // ✅ Update existing assignment
    @PutMapping("/{id}")
    public VehicleAssignmentDTO updateAssignment(@PathVariable int id, @RequestBody VehicleAssignmentDTO dto) {
        return service.updateAssignment(id, dto);
    }

    // ✅ Delete assignment by ID
    @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable int id) {
        service.deleteAssignment(id);
    }
}

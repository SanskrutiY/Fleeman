package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.FuelLogService;
import dto.FuelLogDTO;

@RestController
@RequestMapping("/api/fuellogs")
public class FuelLogController {
	@Autowired
    private FuelLogService fuelLogService;

    @GetMapping
    public ResponseEntity<List<FuelLogDTO>> getAllFuelLogs() {
        List<FuelLogDTO> logs = fuelLogService.getAllFuelLogs();
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<FuelLogDTO> getFuelLogByVehicleId(@PathVariable int vehicleId) {
        FuelLogDTO log = fuelLogService.getFuelLogByVehicleId(vehicleId);
        if (log != null) return ResponseEntity.ok(log);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/assignment/{assignmentId}")
    public ResponseEntity<List<FuelLogDTO>> getFuelLogsByAssignmentId(@PathVariable int assignmentId) {
        List<FuelLogDTO> logs = fuelLogService.getFuelLogsByAssignmentId(assignmentId);
        return ResponseEntity.ok(logs);
    }

    @PostMapping
    public ResponseEntity<FuelLogDTO> createFuelLog(@RequestBody FuelLogDTO dto) {
        FuelLogDTO created = fuelLogService.createFuelLog(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuelLogDTO> updateFuelLog(@PathVariable int id, @RequestBody FuelLogDTO dto) {
        FuelLogDTO updated = fuelLogService.updateFuelLog(id, dto);
        if (updated != null) return ResponseEntity.ok(updated);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuelLog(@PathVariable int id) {
        fuelLogService.deleteFuelLog(id);
        return ResponseEntity.noContent().build();
    }
}

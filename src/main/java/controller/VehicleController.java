package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dto.VehicleDTO;
import enums.AddonType;
import enums.VehicleType;
import service.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping
	public ResponseEntity<List<VehicleDTO>> getAllVehicles(){
		List<VehicleDTO> vehDto = vehicleService.getAllVehicles();
		return ResponseEntity.ok(vehDto);
	}
	
	@GetMapping("/types")
	public List<String> getVehiclesType() {
		return List.of(VehicleType.values()).stream()
				.map(val -> val.stringValue()).toList();
	}
}
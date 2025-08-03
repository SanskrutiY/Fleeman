package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import service.RateService;
import dto.RateDTO;

@RestController
@RequestMapping("/api/rates")
public class RateController {
	@Autowired
    private RateService rateService;

    @GetMapping
    public ResponseEntity<List<RateDTO>> getAllRates() {
        return ResponseEntity.ok(rateService.getAllRates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RateDTO> getRateById(@PathVariable int id) {
        RateDTO dto = rateService.getRateById(id);
        return (dto != null) ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<RateDTO>> getRatesByVehicleId(@PathVariable int vehicleId) {
        List<RateDTO> list = rateService.getRatesByVehicleId(vehicleId);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<RateDTO> createRate(@RequestBody RateDTO dto) {
        return ResponseEntity.ok(rateService.createRate(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RateDTO> updateRate(@PathVariable int id, @RequestBody RateDTO dto) {
        RateDTO updated = rateService.updateRate(id, dto);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRate(@PathVariable int id) {
        rateService.deleteRate(id);
        return ResponseEntity.noContent().build();
    }
}

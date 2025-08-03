package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.BookingDTO;
import service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@GetMapping
	public ResponseEntity<List<BookingDTO>> getAllBookings(){
		List<BookingDTO> bookDto = bookingService.getAllBookings();
		return ResponseEntity.ok(bookDto);
	}
	
	// get by id
	@GetMapping("/{id}")
	public ResponseEntity<BookingDTO> getBookingById(@PathVariable("id") int id){
		BookingDTO bookDto = bookingService.getBookingById(id);
		return ResponseEntity.ok(bookDto);
	}
	
	// create
	@PostMapping("/create")
	public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO){
		BookingDTO bookDto = bookingService.createBooking(bookingDTO);
		return ResponseEntity.ok(bookDto);
	}
	
	// assign vehicles to booking - used by ADMIN
//	BODY -> 
//	{
//	  "bookingId": 100,
//	  "vehicleId": 102,
//	  "localDl": "134343asdsa",
//	  "returnDate": "2025-01-01"
//	}
	@PostMapping("/assign-vehicle")
	public ResponseEntity<Map<String, Boolean>> assignVehicleToBooking(@RequestBody Map<String, String> body){		
		try {
			bookingService.assignVehicleToBooking(body);
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("error", true));
		}
		
		return ResponseEntity.ok(Map.of("success", true));
	}
	
	// delete by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBookingById(@PathVariable("id") int id){
		bookingService.deleteBooking(id);
		return ResponseEntity.ok(Map.of("success", true));
	}
	
}

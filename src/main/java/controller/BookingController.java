package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}

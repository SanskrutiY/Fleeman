package service;

import java.util.List;
import java.util.Map;

import dto.BookingDTO;

public interface BookingService {
	List<BookingDTO> getAllBookings();
	BookingDTO getBookingById(int bookingId);
	BookingDTO createBooking(BookingDTO bookingDTO);
	BookingDTO updateBooking(int bookingId, BookingDTO bookingDTO);
	void deleteBooking(int bookingId);
	void assignVehicleToBooking(Map<String, String> body);
}

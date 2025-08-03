package service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.BookingDTO;
import entity.Booking;
import entity.Vehicle;
import entity.VehicleAssignment;
import mapper.Mapper;
import repository.BookingRepository;
import repository.VehicleAssignmentRepository;
import repository.VehicleRepository;
import service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepo;

	@Autowired
	private VehicleRepository vehicleRepo;
	
	@Autowired
	private VehicleAssignmentRepository assignmentRepository;
	
	@Override
	public List<BookingDTO> getAllBookings() {
		List<Booking> bookingList = bookingRepo.findAll();
		List<BookingDTO> bookingDtoList = new ArrayList<>();
		for (Booking bookings : bookingList) {
			bookingDtoList.add(Mapper.mapToBookingDTO(bookings));
	    }
	    return bookingDtoList;
	}

	@Override
	public BookingDTO getBookingById(int bookingId) {
		return Mapper.mapToBookingDTO(bookingRepo.getById(bookingId));
	}

	@Override
	public BookingDTO createBooking(BookingDTO bookingDTO) {
		Booking booking = bookingRepo.save(Mapper.mapToBookingEntity(bookingDTO));
		if (booking != null) {
			return Mapper.mapToBookingDTO(booking);
		}
		return null;
	}
	
	@Override
	public void assignVehicleToBooking(Map<String, String> body) {
		int bookingId = Integer.valueOf(body.get("bookingId"));
		int vehicleId = Integer.valueOf(body.get("vehicleId"));
		String localDl = body.get("localDl");
		String returnDate = body.get("returnDate");
		
		Vehicle vehicle = vehicleRepo.getById(vehicleId);
		Booking booking = bookingRepo.getById(bookingId);
		
		VehicleAssignment assignment = new VehicleAssignment();
		assignment.setAssignDate(LocalDate.now());
		assignment.setBooking(booking);
		assignment.setVehicle(vehicle);
		assignment.setLocalDl(localDl);
		
		// Convert returnDate string to LocalDate and set
		assignment.setReturnDate(null);
		
		assignmentRepository.save(assignment);
	}

	@Override
	public BookingDTO updateBooking(int bookingId, BookingDTO bookingDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBooking(int bookingId) {
		bookingRepo.deleteById(bookingId);
	}
	
}

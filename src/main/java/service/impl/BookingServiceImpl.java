package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.BookingDTO;
import entity.Booking;
import mapper.Mapper;
import repository.BookingRepository;
import service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepo;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingDTO createBooking(BookingDTO bookingDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingDTO updateBooking(int bookingId, BookingDTO bookingDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBooking(int bookingId) {
		// TODO Auto-generated method stub
		
	}
	
}

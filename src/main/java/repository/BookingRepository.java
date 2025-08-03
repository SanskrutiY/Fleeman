package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
}

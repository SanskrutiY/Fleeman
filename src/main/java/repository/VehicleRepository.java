package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
//	Vehicle findByRegistrationId(String registrationId);
}

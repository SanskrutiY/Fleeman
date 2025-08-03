package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
	Optional<Location> findByHubId(int hubId);
	List<Location> findByAirportCode(String airportCode);
}

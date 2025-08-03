package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import entity.Rate;

public interface RateRepository extends JpaRepository<Rate, Integer> {
    List<Rate> findByVehicleVehicleId(int vehicleId);
}

package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import entity.VehicleAssignment;

public interface VehicleAssignmentRepository extends JpaRepository<VehicleAssignment, Integer>{
//	 List<VehicleAssignment> findByCustomer_CustId(int custId);
}

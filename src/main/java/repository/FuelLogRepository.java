package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.FuelLogs;

public interface FuelLogRepository extends JpaRepository<FuelLogs, Integer> {
//	List<FuelLogs> findByAssignmentAssignmentId(int assignmentId);
}

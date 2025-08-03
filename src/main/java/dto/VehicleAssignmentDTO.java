package dto;

import lombok.*;
import java.time.LocalDate;

import entity.Vehicle;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleAssignmentDTO {
    private int assignmentId;
    private VehicleDTO vehicle;
    private FuelLogDTO fuelLog;
    private int customerId;
    private int bookingId;
    private String localDl;
    private LocalDate assignDate;
    private LocalDate returnDate;
}

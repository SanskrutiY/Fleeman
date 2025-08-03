package dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleAssignmentDTO {
    private int assignmentId;
    private int vehicleId;
    private int customerId;
    private int bookingId;
    private String localDl;
    private LocalDate assignDate;
    private LocalDate returnDate;
}

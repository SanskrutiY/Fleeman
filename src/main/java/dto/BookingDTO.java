package dto;

import java.time.LocalDate;
import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private int bookingId;
    // dont pass assignments while booking create from Frontend
    private List<VehicleAssignmentDTO> vehicleAssignments;
    private int customerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String pickupLocation;
    private String dropdownLocation;
    private String status;
}

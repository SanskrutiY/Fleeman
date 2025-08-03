package dto;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private int bookingId;
    private int vehicleId;
    private int customerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String pickupLocation;
    private String dropdownLocation;
    private String status;
}

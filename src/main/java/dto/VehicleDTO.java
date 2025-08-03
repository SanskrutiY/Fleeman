package dto;

import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
	private String model;
    private String type;
    private LocalDate year;
    private String status;
    private int mileage;
    private int rateId;
}
package dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuelLogDTO {
    private int fuelId;
    private int assignmentId;
    private BigDecimal startVolume;
    private LocalDate date;
    private BigDecimal endVolume;
}

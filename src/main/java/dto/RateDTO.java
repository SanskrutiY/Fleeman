package dto;

import java.math.BigDecimal;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateDTO implements Serializable {
    private int rateId;
    private int dailyRate;
    private int weeklyRate;
    private int monthlyRate;
    private String season;

    private int vehicleId;

    private BigDecimal gpsNavigation;
    private BigDecimal campingKit;
    private BigDecimal childSeats;
}

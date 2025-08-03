package dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddOnDTO {

    private int addonId;

    private String gpsNavigation;
    private String campingKit;
    private String childSeats;
    private Integer bookingId;
}

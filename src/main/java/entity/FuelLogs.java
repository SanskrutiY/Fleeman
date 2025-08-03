package entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fuel_log")
public class FuelLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fuel_id")
    private int fuelId;

//    @OneToOne
//    @JoinColumn(name = "assignment_id")
//    private VehicleAssignment assignment;

    private LocalDate date;
    private BigDecimal startVolume;
    private BigDecimal endVolume;
}

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
    private int fuel_id;

    @OneToOne
    @JoinColumn(name = "assignment_id")
    private VehicleAssignment assignment;

    private BigDecimal fuelVolume;
    private LocalDate date;
    private BigDecimal endVolume;
}

package entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rateId;

//    @Column(length = 20)
//    private String carModel;

    private int dailyRate;
    private int weeklyRate;
    private int monthlyRate;

    @Column(length = 20)
    private String season;
    
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private BigDecimal gpsNavigation;
    private BigDecimal campingKit;
    private BigDecimal childSeats;
    
}


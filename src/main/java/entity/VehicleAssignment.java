package entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle_assignment")
public class VehicleAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int assignmentId;
    private String localDl;
    private LocalDate assignDate;
    private LocalDate returnDate;

//    @ManyToOne
//    @JoinColumn(name = "vehicle_id")
//    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
    private Vehicle vehicle;

//    @ManyToOne
//    @JoinColumn(name = "cust_id", nullable = false)
//    private Customer customer;

    
    // @ManyToOne  
    // ????????????????
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @OneToOne
    @JoinColumn(name = "fuel_id", referencedColumnName = "fuel_id")
    private FuelLogs fuelLog;

//    @OneToMany(mappedBy = "assignment")
//    private List<Payment> payments;
}

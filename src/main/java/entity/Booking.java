package entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;
    
    // Below 2 variables are for Mapper class methods
    @Column(name = "cust_id", insertable = false, updatable = false)
    private int customerId;

    @Column(name = "vehicle_id", insertable = false, updatable = false)
    private int vehicleId;

    private LocalDate startDate;
    private LocalDate endDate;
    private String pickupLocation;
    private String dropdownLocation;
    private String status;

//    @Column(length = 1)
//    private String status = "U";

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<AddOn> addOns;

    // @OneToMany ?????????? acc to Harshal DB ER
    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private VehicleAssignment vehicleAssignment;
    
    // I think it should be OneToOne ?????????
//    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
//    private List<Payment> payments;
}
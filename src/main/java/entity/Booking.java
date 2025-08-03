package entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    // Below 2 variables are for Mapper class methods
    @Column(name = "cust_id", updatable = false)
    private int customerId;

    private LocalDate startDate;
    private LocalDate endDate;
    private String pickupLocation;
    private String dropdownLocation;
    private String status;

//    @Column(length = 1)
//    private String status = "U";

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;
    
    @ManyToMany
    @JoinTable(
        name = "booking_addon",
        joinColumns = @JoinColumn(name = "booking_id"),
        inverseJoinColumns = @JoinColumn(name = "addon_id")
    )
    private Set<Addon> addons = new HashSet();

    // @OneToMany ?????????? acc to Harshal DB ER
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<VehicleAssignment> vehicleAssignments;
    
    // I think it should be OneToOne ?????????
//    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
//    private List<Payment> payments;
}
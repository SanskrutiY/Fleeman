package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private int custId;

    @Column(name = "full_name", nullable = false, unique = true)
    private String fullName;

    private String address;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "phone_num", nullable = false)
    private long phoneNum;

    private String city;
    private String creditCardType;

    @Column(unique = true)
    private Long creditCardNum;

    @Column(name = "local_dl", nullable = false)
    private String localDl;

    @Column(name = "ldl_provider", nullable = false)
    private String ldlProvider;

    @Column(name = "international_dl", nullable = false)
    private String internationalDl;

    @Column(name = "idl_provider", nullable = false)
    private String idlProvider;

    private String zip;
    private LocalDate dateOfBirth;

    @Column(name = "passport_num", nullable = false, unique = true)
    private String passportNum;

    @Column(name = "passport_valid", nullable = false)
    private LocalDate passportValid;
    
//    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id", nullable = false)
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    public List<FuelLog> fuelog;
 	
 	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
 	public List<Booking> bookings;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    public List<VehicleAssignment> vehicle_assignments;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    public List<Payment> payments;
    
}


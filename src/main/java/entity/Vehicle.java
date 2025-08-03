package entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private int vehicleId;

    @Column(name = "registration_id", unique = true, nullable = false)
    private String registrationId;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private LocalDate year;

    @Column(nullable = false)
    private String type;

    private String status = "UnBooked";
    @Column(name = "last_service")
    private LocalDate lastService;
    private int mileage;

    @Column(name = "car_image", nullable = false, unique = true)
    private String carImage;

//    @OneToMany(mappedBy = "vehicle")
////    private Booking booking;
//    private List<Booking> bookings;

//    @OneToOne
//    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
//    private VehicleAssignment vehicleAssignment;

    @OneToMany(mappedBy = "vehicle")
    private List<Insurance> insurances;

    @OneToOne
    @JoinColumn(name = "rate_id", referencedColumnName = "rate_id")
    private Rate rate;
}

package entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

//    @ManyToOne
//    @JoinColumn(name = "booking_id")
//    private Booking booking;
//
//    @ManyToOne
//    @JoinColumn(name = "assignment_id")
//    private VehicleAssignment assignment;
//
//    @ManyToOne
//    @JoinColumn(name = "cust_id")
//    private Customer customer;

    private String paymentType;
    private Long cardNum;
    private Integer totalAddon;
    private LocalDate date;
//    private String addon;
//    @ManyToOne
//    @JoinColumn(name = "addon_id")
//    private AddOn addon;
    private int total;
}

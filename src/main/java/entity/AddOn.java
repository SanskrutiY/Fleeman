package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "add_on")
public class AddOn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addon_id")
    private int addonId;

    @Column(name = "gps_navigation", length = 20)
    private String gpsNavigation;

    @Column(name = "camping_kit", length = 20)
    private String campingKit;

    @Column(name = "child_seats", length = 20)
    private String childSeats;
    
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Booking booking;

    @OneToMany(mappedBy = "addOn")
    private List<Payment> payments;
}
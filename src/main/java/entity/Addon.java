package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import enums.AddonType;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "add_on")
public class Addon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addon_id")
    private int addonId;

    @Column(name = "addon_type")
    private String addonType;
    
    @ManyToMany(mappedBy = "addons")
    private Set<Booking> bookings = new HashSet<>();

//    @OneToMany(mappedBy = "addon")
//    private List<Payment> payments;
}
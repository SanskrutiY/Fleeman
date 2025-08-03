package entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hub_id")
    private int hubId;

    @Column(name = "hub_address", length = 100)
    private String hubAddress;

    @Column(length = 20)
    private String city;

    @Column(length = 20)
    private String state;

    @Column(name = "airport_code", length = 20)
    private String airportCode;

}
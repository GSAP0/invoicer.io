package io.invoicer.crm.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String label; // e.g., "Billing", "Shipping"

    @Column(nullable = false)
    private String street;

    private String city;

    private String state;

    private String postalCode;

    @Column(length = 2)
    private String country;

    private boolean primaryAddress;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}

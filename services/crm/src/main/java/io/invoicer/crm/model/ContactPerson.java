package io.invoicer.crm.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contact_people")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String phone;

    private String email;

    private String role;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}

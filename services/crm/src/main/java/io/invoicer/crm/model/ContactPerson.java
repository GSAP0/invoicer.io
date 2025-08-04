package io.invoicer.crm.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "customer_contacts")
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

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}

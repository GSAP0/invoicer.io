package io.invoicer.crm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL auto-increment
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Email
    @Column(nullable = false, unique = true, length = 320)
    private String email;

    @Column(length = 32)
    private String phone;

    @Column(length = 255)
    private String company;

    @Column(length = 64)
    private String taxId;

    @Column(length = 64)
    private String vatNumber;

    @Column(length = 2)
    private String country;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    @Builder.Default
    private Status status = Status.ACTIVE;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant updatedAt;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContactPerson> contactPeople = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerTag> tags = new ArrayList<>();;

    public enum Status {
        ACTIVE, INACTIVE, BLACKLISTED
    }
}

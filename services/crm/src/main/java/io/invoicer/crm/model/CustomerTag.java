package io.invoicer.crm.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer_tags")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tag_id")
    private Tag tag;
}

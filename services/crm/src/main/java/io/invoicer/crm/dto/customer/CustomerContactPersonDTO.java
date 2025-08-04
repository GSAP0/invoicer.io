package io.invoicer.crm.dto.customer;

import lombok.Data;

import java.time.Instant;

@Data
public class CustomerContactPersonDTO {
    public Long id;
    public String fullName;
    public String phone;
    public String email;
    public String role;
    private Instant createdAt;
    private Instant updatedAt;
    public Long customerId;
}

package io.invoicer.crm.dto.customer;

import java.time.Instant;

public class CustomerNoteDTO {
    public Long id;
    public Long customerId;
    public String content;
    public Instant createdAt;
    public Instant updatedAt;
}

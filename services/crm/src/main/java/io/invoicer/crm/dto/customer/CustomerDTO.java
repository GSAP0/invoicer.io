package io.invoicer.crm.dto.customer;

import io.invoicer.crm.model.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Data
@Getter
@Setter
public class CustomerDTO {
    public Long id;
    public String name;
    public String email;
    public String phone;
    public String company;
    public String taxId;
    public String country;
    public Customer.Status status = Customer.Status.ACTIVE;
    private Instant createdAt;
    private Instant updatedAt;
//    private List<CustomerAddressDTO> addresses;
//    private List<CustomerContactPersonDTO> contactPeople;
//    private List<CustomerNoteDTO> notes;
//    private List<CustomerTagDTO> tags;
}

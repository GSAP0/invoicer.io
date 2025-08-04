package io.invoicer.crm.dto.customer;

import io.invoicer.crm.model.*;
import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
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
    private List<CustomerAddressDTO> addresses = new ArrayList<>();
    private List<CustomerContactPersonDTO> contactPeople = new ArrayList<>();
    private List<CustomerNoteDTO> notes = new ArrayList<>();
    private List<CustomerTagDTO> tagList = new ArrayList<>();
}

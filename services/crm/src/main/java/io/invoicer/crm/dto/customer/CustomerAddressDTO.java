package io.invoicer.crm.dto.customer;

import lombok.Data;

@Data
public class CustomerAddressDTO {
    public Long id;
    public String label;
    public String street;
    public String city;
    public String state;
    public String postalCode;
    public String country;
    public boolean primaryAddress;
    public Long customerId;
}
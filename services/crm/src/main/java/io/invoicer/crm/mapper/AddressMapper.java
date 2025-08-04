package io.invoicer.crm.mapper;

import io.invoicer.crm.dto.customer.CustomerAddressDTO;
import io.invoicer.crm.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    CustomerAddressDTO toDTO(Address address);
    Address toEntity(CustomerAddressDTO customerAddressDTO);
}

package io.invoicer.crm.mapper;

import io.invoicer.crm.dto.customer.CustomerAddressDTO;
import io.invoicer.crm.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper( AddressMapper.class );

    CustomerAddressDTO toDTO(Address address);

    Address toEntity(CustomerAddressDTO customerAddressDTO);
}

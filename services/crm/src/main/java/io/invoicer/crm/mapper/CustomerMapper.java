package io.invoicer.crm.mapper;

import io.invoicer.crm.dto.customer.CustomerDTO;
import io.invoicer.crm.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );

    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);

}

package io.invoicer.crm.mapper;

import io.invoicer.crm.dto.customer.CustomerContactPersonDTO;
import io.invoicer.crm.model.ContactPerson;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactPersonMapper {

    ContactPersonMapper INSTANCE = Mappers.getMapper( ContactPersonMapper.class );

    CustomerContactPersonDTO toDTO(ContactPerson contactPerson);

    ContactPerson toEntity(CustomerContactPersonDTO customerContactPersonDTO);
}

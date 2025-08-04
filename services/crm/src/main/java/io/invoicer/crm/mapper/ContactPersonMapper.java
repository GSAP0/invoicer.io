package io.invoicer.crm.mapper;

import io.invoicer.crm.dto.customer.CustomerContactPersonDTO;
import io.invoicer.crm.model.ContactPerson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactPersonMapper {
    CustomerContactPersonDTO toDTO(ContactPerson contactPerson);
    ContactPerson toEntity(CustomerContactPersonDTO customerContactPersonDTO);
}

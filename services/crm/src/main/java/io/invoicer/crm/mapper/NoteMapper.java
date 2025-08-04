package io.invoicer.crm.mapper;

import io.invoicer.crm.dto.customer.CustomerNoteDTO;
import io.invoicer.crm.model.Note;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    CustomerNoteDTO toDTO(Note note);

    Note toEntity(CustomerNoteDTO customerNoteDTO);
}

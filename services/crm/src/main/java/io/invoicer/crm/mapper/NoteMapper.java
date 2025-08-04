package io.invoicer.crm.mapper;

import io.invoicer.crm.dto.customer.CustomerNoteDTO;
import io.invoicer.crm.model.Note;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NoteMapper {

    NoteMapper INSTANCE = Mappers.getMapper( NoteMapper.class );

    CustomerNoteDTO toDTO(Note note);

    Note toEntity(CustomerNoteDTO customerNoteDTO);
}

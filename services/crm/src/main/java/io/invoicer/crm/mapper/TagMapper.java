package io.invoicer.crm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagMapper {
    TagMapper INSTANCE = Mappers.getMapper( TagMapper.class );
}

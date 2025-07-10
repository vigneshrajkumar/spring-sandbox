package com.rajkumarv.sandbox.mapper;

import com.rajkumarv.sandbox.dto.PersonDto;
import com.rajkumarv.sandbox.model.Person;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {
    Person toEntity(PersonDto personDto);
    PersonDto toDto(Person person);
}


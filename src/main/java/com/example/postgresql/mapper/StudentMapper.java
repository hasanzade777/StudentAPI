package com.example.postgresql.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

import com.example.postgresql.dto.StudentDto;
import com.example.postgresql.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface StudentMapper {

    @Mapping(target = "firstName", source = "name")
    StudentDto mapToDto(Student student);
}

package dev.cironeto.springbootdevdojo.mapper;

import dev.cironeto.springbootdevdojo.domain.Student;
import dev.cironeto.springbootdevdojo.requests.StudentPostRequestBody;
import dev.cironeto.springbootdevdojo.requests.StudentPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {

    public static final StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    public abstract Student toStudent(StudentPostRequestBody studentPostRequestBody);

    public abstract Student toStudent(StudentPutRequestBody studentPutRequestBody);

}

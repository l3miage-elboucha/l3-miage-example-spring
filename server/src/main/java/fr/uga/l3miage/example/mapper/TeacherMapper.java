package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.Teacher;
import fr.uga.l3miage.example.response.TeacherDTO;
import org.mapstruct.Mapper;


@Mapper(uses=Teacher.class)

public interface TeacherMapper {

    TeacherDTO entityToDTO(Teacher teacher);
    Teacher dtoToEntity(TeacherDTO teacherDTO);
}

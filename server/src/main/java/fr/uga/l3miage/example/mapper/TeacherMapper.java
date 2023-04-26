package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.Teacher;
import fr.uga.l3miage.example.response.TeacherDTO;
import org.mapstruct.Mapper;

@Mapper(uses = Teacher.class)
public interface TeacherMapper {
    TeacherDTO entitytoDTO(Teacher teacher);
    Teacher dTOtoEntity(TeacherDTO teacherDTO);
}

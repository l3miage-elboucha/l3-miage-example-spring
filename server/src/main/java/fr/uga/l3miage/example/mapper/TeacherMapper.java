package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.Teacher;
import fr.uga.l3miage.example.models.TestEntity;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.TeacherDTO;
import fr.uga.l3miage.example.response.Test;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(uses = Teacher.class)
public interface TeacherMapper {

    TeacherDTO entityToDTO(Teacher teacher);
    Teacher dtoToEntity(TeacherDTO teacherDTO);
}

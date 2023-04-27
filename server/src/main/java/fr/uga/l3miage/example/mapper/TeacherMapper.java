package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.Teacher;
import fr.uga.l3miage.example.models.TestEntity;
import fr.uga.l3miage.example.request.CreateTeacherRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.TeacherDTO;
import fr.uga.l3miage.example.response.Test;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherDTO entityToDTO(Teacher teacher);
    Teacher dtoToEntity(CreateTeacherRequest requestDTO);
    Teacher dtoToEntity(TeacherDTO teacherDTO);
    @Mapping(source="createdMiahoots",target="createdMiahoots" , qualifiedBy = TestMapperUtils.listMiahootToListMiahootDTO.class)
    @Mapping(source="presentedMiahoots",target="presentedMiahoots" , qualifiedBy = TestMapperUtils.listMiahootToListMiahootDTO.class)
    List<Miahoot> map(List<MiahootDTO > miahootDTOList);
}

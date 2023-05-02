package fr.uga.l3miage.example.mapper;


import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.request.CreatMiahootRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.QuestionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MiahootMapper {
    MiahootDTO entitytoDto(Miahoot miahoot);
    Miahoot map(CreatMiahootRequest request);
    Miahoot dtoToEntity(MiahootDTO miahootDTO);
    List<Question> map(List<QuestionDTO> questions);

}


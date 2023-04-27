package fr.uga.l3miage.example.mapper;


import fr.uga.l3miage.example.response.QuestionDTO;
import fr.uga.l3miage.example.models.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question dtoToEntity(QuestionDTO question);
    QuestionDTO entityToDto(Question question);
}

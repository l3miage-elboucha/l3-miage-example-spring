package fr.uga.l3miage.example.mapper;


import fr.uga.l3miage.example.dto.QuestionDTO;
import fr.uga.l3miage.example.models.Question;
import org.mapstruct.Mapper;

@Mapper(uses = Question.class)
public interface QuestionMapper {

    Question dtoToEntity(QuestionDTO question);
    QuestionDTO entityToDto(Question question);
}

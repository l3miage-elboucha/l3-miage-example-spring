package fr.uga.l3miage.example.mapper;


import fr.uga.l3miage.example.models.Response;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.QuestionDTO;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.response.ResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses= ResponseMapper.class)
public interface QuestionMapper {

    Question dtoToEntity(QuestionDTO question);
    QuestionDTO entityToDto(Question question);
    Question  dtoToEntity(CreateQuestionRequest request);
    List<Response> map(List<ResponseDTO> responseDTOList);
}

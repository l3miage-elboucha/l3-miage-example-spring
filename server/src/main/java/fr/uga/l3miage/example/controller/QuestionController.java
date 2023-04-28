package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.QuestionEndpoint;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.QuestionDTO;
import fr.uga.l3miage.example.service.ServiceQuestion;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController implements QuestionEndpoint {
    private final ServiceQuestion serviceQuestion;
    @Override
    public QuestionDTO getQuestion(Long id){return serviceQuestion.getQuestionById(id);
    }
    @Override
    public void createQuestion(Long miahootId , CreateQuestionRequest request){ serviceQuestion.createQuestion(miahootId,request);}
    @Override
    public void deleteQuestion(Long  id){serviceQuestion.deleteQuestion(id);}

    @Override
    public void updateQuestion(Long id , String newLabel){
        serviceQuestion.updateQuestion(id,newLabel);
    }
}

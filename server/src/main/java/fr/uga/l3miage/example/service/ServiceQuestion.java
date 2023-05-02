package fr.uga.l3miage.example.service;


import fr.uga.l3miage.example.component.QuestionComponent;
import fr.uga.l3miage.example.exception.technical.QuestionAlreadyExistsException;
import fr.uga.l3miage.example.exception.technical.QuestionNotFoundException;
import fr.uga.l3miage.example.mapper.QuestionMapper;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.repository.QuestionRepository;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.QuestionDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ServiceQuestion {

    private static final String ERROR_DETECTED = "Une erreur lors de la création de l'entité Question à été détecté.";
    private final QuestionRepository questionRepository ;
    private final QuestionMapper questionMapper;
    private final QuestionComponent questionComponent ;


    public QuestionDTO getQuestionById(final Long id) throws QuestionNotFoundException {
        try {
            return questionMapper.entityToDto(questionComponent.getQuestion(id));
        } catch (QuestionNotFoundException ex) {
            throw new QuestionNotFoundException("Impossible de charger l'entité."+id);
        }
    }

    public QuestionDTO createQuestion(final Long miahootId ,final CreateQuestionRequest request) throws QuestionAlreadyExistsException {
        Question newQuestion = questionMapper.dtoToEntity(request);
        try {
            return questionComponent.createQuestion(miahootId,newQuestion);
        }catch (QuestionAlreadyExistsException ex) {
            throw new QuestionAlreadyExistsException("la question "+newQuestion.getId() +" existe deja");
        }
    }


    @SneakyThrows
    @Transactional
    public void updateQuestion(final Long id, final QuestionDTO question) throws QuestionNotFoundException {
        try {
            questionComponent.updateQuestion(id, question);
        } catch (QuestionNotFoundException ex) {
            throw new QuestionNotFoundException("Impossible de charger l'entité."+ id);
        }
    }
    @SneakyThrows
    @Transactional
    public void deleteQuestion(final Long id) throws QuestionNotFoundException {
        if (id != null) {
            questionComponent.deleteQuestion(id); ;
        }else {
            throw  new QuestionNotFoundException("ce "+ id+" ne correspond a aucune question  existant");
        }

    }
}

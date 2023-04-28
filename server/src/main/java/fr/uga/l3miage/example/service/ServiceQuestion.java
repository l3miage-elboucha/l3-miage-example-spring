package fr.uga.l3miage.example.service;


import fr.uga.l3miage.example.component.MiahootComponent;
import fr.uga.l3miage.example.component.QuestionComponent;
import fr.uga.l3miage.example.exception.technical.*;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.mapper.QuestionMapper;
import fr.uga.l3miage.example.models.Participant;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.repository.MiahootRepository;
import fr.uga.l3miage.example.repository.QuestionRepository;
import fr.uga.l3miage.example.request.CreateParticipantRequest;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
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

    public void createQuestion(final CreateQuestionRequest request) throws QuestionAlreadyExistsException {
        Question newQuestion = questionMapper.dtoToEntity(request);
        try {
            questionComponent.createQuestion(newQuestion);
        }catch (QuestionAlreadyExistsException ex) {
            throw new QuestionAlreadyExistsException("la question "+newQuestion.getId() +" existe deja");
        }
    }


    @SneakyThrows
    @Transactional
    public void updateQuestion(final Long id, final String label) throws QuestionNotFoundException {
        try {
            questionComponent.updateQuestion(id, label);
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

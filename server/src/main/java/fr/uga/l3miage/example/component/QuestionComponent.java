package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.exception.technical.MiahootEntityNotFoundException;
import fr.uga.l3miage.example.exception.technical.QuestionNotFoundException;
import fr.uga.l3miage.example.mapper.QuestionMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.repository.QuestionRepository;
import fr.uga.l3miage.example.response.QuestionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionComponent {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final MiahootComponent miahootComponent ;

    public Question getQuestion(final Long id ) throws QuestionNotFoundException {
        return questionRepository.getQuestionById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Aucune question ne possede" + id ));
    }

    public QuestionDTO createQuestion(Long miahootId , final Question question) throws QuestionNotFoundException {

        if (questionRepository.getQuestionById(question.getId()).isPresent()) {
            throw new QuestionNotFoundException("La question suivant "+ question.getId()+"deja existante.");
        } else if(miahootComponent.getMiahoot(miahootId) == null){
            throw new MiahootEntityNotFoundException("La miahoot suivant   n'existant pas .",miahootId);
        }else {
            Miahoot miahoot = miahootComponent.getMiahoot(miahootId) ;
            question.setMiahoot(miahoot);
            questionRepository.save(question);
            return questionMapper.entityToDto(question) ;
        }

    }

    public void updateQuestion(final Long id, final String label) throws QuestionNotFoundException {
        Question newQuestion = questionRepository.getQuestionById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Aucune entité n'a été trouvée avec cette question " + id));
        newQuestion.setLabel(label);
        questionRepository.save(newQuestion);
    }
    public void deleteQuestion(final Long id) throws QuestionNotFoundException {
        Long deleted = questionRepository.deleteQuestionById(id);
        if (deleted == 0)
            throw new QuestionNotFoundException("Aucune question ne possede"+ id);

    }
}

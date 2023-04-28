package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.exception.technical.MiahootEntityNotFoundException;
import fr.uga.l3miage.example.exception.technical.QuestionNotFoundException;
import fr.uga.l3miage.example.exception.technical.TeacherEntityNotFoundException;
import fr.uga.l3miage.example.mapper.QuestionMapper;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.models.Teacher;
import fr.uga.l3miage.example.repository.QuestionRepository;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.QuestionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionComponent {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    public Question getQuestion(final Long id ) throws QuestionNotFoundException {
        return questionRepository.getQuestionById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Aucune question ne possede" + id ));
    }

    public void createQuestion(final Question question) throws QuestionNotFoundException {

        if (questionRepository.getQuestionById(question.getId()).isPresent()) {
            throw new QuestionNotFoundException("La question suivant "+ question.getId()+"deja existante.");
        } else {
            questionRepository.save(question);
        }
    }

    public void updateQuestion(final Long id, final String label) throws QuestionNotFoundException {
        Question newQuestion = questionRepository.getQuestionById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Aucune entité n'a été trouvée avec ce Username " + id));
        newQuestion.setLabel(label);
        questionRepository.save(newQuestion);
    }
    public void deleteQuestion(final Long id) throws QuestionNotFoundException {
        Long deleted = questionRepository.deleteQuestionById(id);
        if (deleted == 0)
            throw new QuestionNotFoundException("Aucune question ne possede"+ id);

    }
}

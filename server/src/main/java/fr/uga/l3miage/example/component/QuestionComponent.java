package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.exception.technical.QuestionNotFoundException;
import fr.uga.l3miage.example.mapper.QuestionMapper;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.repository.QuestionRepository;
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

    public void deleteQuestion(final Long id) throws QuestionNotFoundException {
        Long deleted = questionRepository.deleteQuestionById(id);
        if (deleted == 0)
            throw new QuestionNotFoundException("Aucune question ne possede"+ id);

    }
}

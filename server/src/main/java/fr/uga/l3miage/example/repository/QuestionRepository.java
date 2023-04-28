package fr.uga.l3miage.example.repository;

import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.models.Response;
import fr.uga.l3miage.example.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    Optional<Question> getQuestionById(final Long id) ;
    Long deleteQuestionById(final Long id);
    List<Response> get();
}

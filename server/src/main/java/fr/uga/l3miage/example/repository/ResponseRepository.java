package fr.uga.l3miage.example.repository;

import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.models.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResponseRepository extends JpaRepository<Response,Long> {
    Optional<Response> getResponseById(final Long id);
    List<Response> getResponsesByQuestion(final Long questionId);
    Response findResponseById(final Long id);
    Long deleteResponseById(final Long id);

}

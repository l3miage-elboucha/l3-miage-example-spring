package fr.uga.l3miage.example.repository;




import fr.uga.l3miage.example.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant,String> {
    Long deleteParticipantById(Long id);
    Optional<Participant> findParticipantById(Long id);

}

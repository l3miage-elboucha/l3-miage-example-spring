package fr.uga.l3miage.example.component;


import fr.uga.l3miage.example.exception.technical.ParticipantAlreadyExistException;
import fr.uga.l3miage.example.exception.technical.ParticipantEntityNotFoundException;
import fr.uga.l3miage.example.mapper.ParticipantMapper;

import fr.uga.l3miage.example.models.Participant;
import fr.uga.l3miage.example.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParticipantComponent {
    private final ParticipantRepository participantRepository;
    private final ParticipantMapper participantMapper;

    public Participant getParticipant(final Long id ) throws ParticipantEntityNotFoundException {
        return participantRepository.findParticipantById(id)
                .orElseThrow(() -> new ParticipantEntityNotFoundException("Aucune particpant ne possede" + id +"comme username"));
    }

    public void createParticipant(final Participant participant) throws ParticipantAlreadyExistException {

        if (participantRepository.findParticipantById(participant.getId()).isPresent()) {
            throw new ParticipantAlreadyExistException("Le participant suivant "+ participant.getNom()+"deja existant.");
        } else {
            participantRepository.save(participant);
        }
    }
    public void deleteParticipant(final Long id) throws ParticipantEntityNotFoundException {
        Long deleted = participantRepository.deleteParticipantById(id);
        if (deleted == 0)
            throw new ParticipantEntityNotFoundException("Aucune particpant ne possede"+ id+ "comme username");

    }
}

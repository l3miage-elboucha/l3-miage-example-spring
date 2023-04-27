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

    public Participant getParticipant(final String username) throws ParticipantEntityNotFoundException {
        return participantRepository.findParticipantByUserName(username)
                .orElseThrow(() -> new ParticipantEntityNotFoundException("Aucune particpant ne possede" + username +"comme username"));
    }

    public void createParticipant(final Participant participant) throws ParticipantAlreadyExistException {

        if (participantRepository.findParticipantByUserName(participant.getUserName()).isPresent()) {
            throw new ParticipantAlreadyExistException("Le participant suivant "+ participant.getUserName()+"deja existant.");
        } else {
            participantRepository.save(participant);
        }
    }
    public void deleteParticipant(final Participant participant) throws ParticipantEntityNotFoundException {
        Long deleted = participantRepository.deleteParticipantByUserName(participant.getUserName());
        if (deleted == 0)
            throw new ParticipantEntityNotFoundException("Aucune particpant ne possede"+ participant.getUserName()+ "comme username");

    }
}

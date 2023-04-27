package fr.uga.l3miage.example.service;


import fr.uga.l3miage.example.component.ParticipantComponent;
import fr.uga.l3miage.example.response.ParticipantDTO;
import fr.uga.l3miage.example.exception.technical.MiahootEntityNotFoundException;
import fr.uga.l3miage.example.exception.technical.ParticipantAlreadyExistException;
import fr.uga.l3miage.example.exception.technical.ParticipantEntityNotFoundException;
import fr.uga.l3miage.example.mapper.ParticipantMapper;
import fr.uga.l3miage.example.models.Participant;
import fr.uga.l3miage.example.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ParticipantService {
    private static final String ERROR_DETECTED = "Une erreur lors de la création de l'entité Participant à été détecté.";
    private final ParticipantRepository participantRepository ;
    private final ParticipantMapper participantMapper;
    private final ParticipantComponent participantComponent ;

    public ParticipantDTO getParticipant(final Participant participant) {
        try {
            return participantMapper.entityToDTO(participantComponent.getParticipant(participant.getUserName()));
        } catch (MiahootEntityNotFoundException ex) {
            throw new ParticipantEntityNotFoundException("Impossible de charger l'entité."+participant.getUserName());
        }
    }

    public void createParticipant(final ParticipantDTO participantDTO) throws ParticipantAlreadyExistException {
        Participant newParticipant = participantMapper.dtoToEntity(participantDTO);
        String participantUsername = participantMapper.dtoToEntity(participantDTO).getUserName();
        try {
            participantComponent.createParticipant(newParticipant);
        }catch (ParticipantAlreadyExistException ex) {
            throw new ParticipantAlreadyExistException("le participant"+participantUsername +" existe deja");
        }
    }

    @SneakyThrows
    @Transactional
    public void deleteParticipant(Participant participant) throws ParticipantEntityNotFoundException {
        if (participant != null) {
            participantComponent.deleteParticipant(participant);
        }else {
            throw  new ParticipantEntityNotFoundException("le participant "+ participant.getUserName()+"n'existe pas");
        }

    }
}

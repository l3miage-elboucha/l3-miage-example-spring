package fr.uga.l3miage.example.service;


import fr.uga.l3miage.example.component.ParticipantComponent;
import fr.uga.l3miage.example.request.CreateParticipantRequest;
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
    private final ParticipantMapper participantMapper;
    private final ParticipantComponent participantComponent ;

    public ParticipantDTO getParticipant(final Long id) {
        try {
            return participantMapper.entityToDTO(participantComponent.getParticipant(id));
        } catch (MiahootEntityNotFoundException ex) {
            throw new ParticipantEntityNotFoundException("Impossible de charger l'entité."+id);
        }
    }

    public void createParticipant(final CreateParticipantRequest request) throws ParticipantAlreadyExistException {
        Participant newParticipant = participantMapper.dtoToEntity(request);
        try {
            participantComponent.createParticipant(newParticipant);
        }catch (ParticipantAlreadyExistException ex) {
            throw new ParticipantAlreadyExistException("le participant"+newParticipant.getNom() +" existe deja");
        }
    }

    @SneakyThrows
    @Transactional
    public void deleteParticipant(final Long id) throws ParticipantEntityNotFoundException {
        if (id != null) {
            participantComponent.deleteParticipant(id) ;
        }else {
            throw  new ParticipantEntityNotFoundException("ce "+ id+" ne correspond a aucun participant existant");
        }

    }
}

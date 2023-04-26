package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.response.ParticipantDTO;
import fr.uga.l3miage.example.models.Participant;
import org.mapstruct.Mapper;

@Mapper(uses = Participant.class)
public interface ParticipantMapper {
    ParticipantDTO dtoToEntity(Participant participant);
    Participant entityToDTO(ParticipantDTO participantDTO);

}

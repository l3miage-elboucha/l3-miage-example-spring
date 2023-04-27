package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.request.CreateParticipantRequest;
import fr.uga.l3miage.example.response.ParticipantDTO;
import fr.uga.l3miage.example.models.Participant;
import org.mapstruct.Mapper;

@Mapper(uses = Participant.class)
public interface ParticipantMapper {
    Participant dtoToEntity(CreateParticipantRequest request);
    ParticipantDTO entityToDTO(Participant participant);

}

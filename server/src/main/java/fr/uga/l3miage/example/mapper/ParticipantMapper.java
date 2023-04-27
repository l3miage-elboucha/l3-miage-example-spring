package fr.uga.l3miage.example.mapper;

import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.request.CreateParticipantRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.ParticipantDTO;
import fr.uga.l3miage.example.models.Participant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParticipantMapper {
    Participant dtoToEntity(Participant participant);
    Participant dtoToEntity(CreateParticipantRequest request);
    ParticipantDTO entityToDTO(Participant participant);

    List<Participant> map(List<ParticipantDTO> participantDTOList);
    Miahoot toEntity(MiahootDTO miahootDTO);
    MiahootDTO toDto(Miahoot miahoot);

}

package fr.uga.l3miage.example.dto;

import fr.uga.l3miage.example.models.Miahoot;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParticipantDTO {
    Miahoot participantMiahoot;
}

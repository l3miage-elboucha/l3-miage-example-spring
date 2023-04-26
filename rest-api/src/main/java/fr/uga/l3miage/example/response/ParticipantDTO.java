package fr.uga.l3miage.example.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParticipantDTO {
    MiahootDTO participantMiahoot;
}

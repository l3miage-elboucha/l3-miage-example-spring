package fr.uga.l3miage.example.response;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class ParticipantDTO extends UtilisateurDTO {
    MiahootDTO participantMiahoot;
}

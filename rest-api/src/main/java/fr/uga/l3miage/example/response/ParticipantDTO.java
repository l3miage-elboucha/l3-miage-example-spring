package fr.uga.l3miage.example.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
public class ParticipantDTO extends UtilisateurDTO{
    MiahootDTO participantMiahoot;
}

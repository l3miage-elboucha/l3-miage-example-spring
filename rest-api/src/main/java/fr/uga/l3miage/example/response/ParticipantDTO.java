package fr.uga.l3miage.example.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@Builder

public class ParticipantDTO{
    Long id ;
    String nom;
    MiahootDTO participantMiahoot;
}

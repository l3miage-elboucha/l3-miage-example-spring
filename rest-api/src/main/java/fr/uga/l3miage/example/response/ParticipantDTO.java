package fr.uga.l3miage.example.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ParticipantDTO{
    Long id ;
    String nom;
    MiahootDTO participantMiahoot;
}

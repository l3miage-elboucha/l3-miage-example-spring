package fr.uga.l3miage.example.request;

import fr.uga.l3miage.example.response.MiahootDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(description = "Correspond à la requête permettant de créer une entité Participant")
public class CreateParticipantRequest {
    Long id ;
    String nom;
    MiahootDTO participantMiahoot;
}

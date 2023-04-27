package fr.uga.l3miage.example.request;

import fr.uga.l3miage.example.response.MiahootDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Schema(description = "Correspond à la requête permettant de créer une entité Participant")
public class CreateParticipantRequest  {
    private Long id ;
    private String nom;
    private MiahootDTO participantMiahoot;
}

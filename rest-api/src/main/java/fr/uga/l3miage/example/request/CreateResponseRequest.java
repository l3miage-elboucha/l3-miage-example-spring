package fr.uga.l3miage.example.request;

import fr.uga.l3miage.example.response.QuestionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Schema(description = "Correspond à la requête permettant de créer une entité Question")
public class CreateResponseRequest {
    private Long id ;
    private String label ;
    private boolean estValide ;
    private QuestionDTO question;
}

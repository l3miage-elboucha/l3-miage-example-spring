package fr.uga.l3miage.example.request;


import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.ResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@Schema(description = "Correspond à la requête permettant de créer une entité Question")
public class CreateQuestionRequest {
    private Long id ;
    private String label ;
    private List<ResponseDTO> responses ;
}

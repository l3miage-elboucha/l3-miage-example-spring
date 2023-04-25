package fr.uga.l3miage.example.dto;

import fr.uga.l3miage.example.models.Question;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDTO {
     Long id ;
     String label ;
     boolean estValide ;
     Question question;
}

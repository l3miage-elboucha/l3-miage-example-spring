package fr.uga.l3miage.example.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDTO {
     Long id ;
     String label ;
     boolean estValide ;
     /*This attribute below should be removed because we don't need it in the response and it will create a stackoverflow */
     QuestionDTO question;
}

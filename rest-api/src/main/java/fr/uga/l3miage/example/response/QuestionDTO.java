package fr.uga.l3miage.example.response;

import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.Response;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class QuestionDTO {

     Long id ;
     String label ;
     Miahoot miahoot ;
     List<Response> responses ;
}

package fr.uga.l3miage.example.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class QuestionDTO {

     Long id ;
     String label ;
     MiahootDTO miahoot ;
     List<ResponseDTO> responses ;
}

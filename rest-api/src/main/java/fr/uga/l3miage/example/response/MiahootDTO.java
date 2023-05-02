package fr.uga.l3miage.example.response;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MiahootDTO {

     Long id ;
     TeacherDTO presentateur ;
     List<ParticipantDTO> participants ;
     String nom ;
     List<QuestionDTO> questions  ;

}

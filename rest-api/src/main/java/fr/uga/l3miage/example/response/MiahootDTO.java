package fr.uga.l3miage.example.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class MiahootDTO {

     Long id ;
     TeacherDTO presentateur ;
     List<ParticipantDTO> participants ;
     String nom ;
     List<QuestionDTO> questions  ;
     Date miahootBirthday ;
     StatusDTO status;

}

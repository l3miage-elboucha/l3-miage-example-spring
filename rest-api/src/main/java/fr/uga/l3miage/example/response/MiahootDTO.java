package fr.uga.l3miage.example.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class MiahootDTO {

     private Long id ;
     private TeacherDTO concepteur ;
     private String nom ;
     private List<QuestionDTO> questions  ;
     private Date miahootBirthday ;
     private StatusDTO status;

}

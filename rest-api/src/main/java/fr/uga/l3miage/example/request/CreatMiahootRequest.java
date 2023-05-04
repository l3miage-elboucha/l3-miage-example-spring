package fr.uga.l3miage.example.request;


import fr.uga.l3miage.example.response.ParticipantDTO;
import fr.uga.l3miage.example.response.QuestionDTO;
import fr.uga.l3miage.example.response.StatusDTO;
import fr.uga.l3miage.example.response.TeacherDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
@Schema(description = "Correspond à la requête permettant de créer une entité Miahoot")
public class CreatMiahootRequest {
    private Long id ;
    private TeacherDTO presentateur ;
    private List<ParticipantDTO> participants ;
    private String nom ;
    private List<QuestionDTO> questions  ;
    private Date miahootBirthday ;
    private StatusDTO status;



}

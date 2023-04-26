package fr.uga.l3miage.example.response;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MiahootDTO {

    private Long id ;
    private TeacherDTO concepteur ;
    private TeacherDTO presentateur ;
    private List<ParticipantDTO> participants ;
    private String nom ;
    private List<QuestionDTO> questions  ;
}

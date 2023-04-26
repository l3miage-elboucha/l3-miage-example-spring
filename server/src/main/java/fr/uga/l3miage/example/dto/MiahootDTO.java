package fr.uga.l3miage.example.dto;

import fr.uga.l3miage.example.models.Participant;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.models.Teacher;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MiahootDTO {

    private Long id ;
    private Teacher concepteur ;
    private Teacher presentateur ;
    private List<Participant> participants ;
    private String nom ;
    private List<Question> questions  ;
}

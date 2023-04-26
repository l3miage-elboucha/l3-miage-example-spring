package fr.uga.l3miage.example.response;


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

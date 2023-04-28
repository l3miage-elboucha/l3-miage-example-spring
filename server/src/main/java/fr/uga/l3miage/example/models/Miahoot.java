package fr.uga.l3miage.example.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Miahoot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @ManyToOne
    private Teacher concepteur ;

    @ManyToOne
    private Teacher presentateur ;

    @OneToMany(mappedBy = "participantMiahoot")
    private List<Participant> participants ;


    private String nom ;

    // suppresion d'un miahoot cad suppression de ces questions
    @OneToMany(mappedBy = "miahoot",fetch = FetchType.LAZY)
    private List<Question> questions  ;

}
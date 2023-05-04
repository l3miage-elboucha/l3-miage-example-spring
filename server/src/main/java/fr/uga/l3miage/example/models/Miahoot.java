package fr.uga.l3miage.example.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Miahoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    private Teacher concepteur ;

    @ManyToOne
    private Teacher presentateur ;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date miahootBirthday ;

    private Status status ;

    @OneToMany(mappedBy = "participantMiahoot")
    private List<Participant> participants ;


    private String nom ;

    // suppresion d'un miahoot cad suppression de ces questions
    @OneToMany(mappedBy = "miahoot",fetch = FetchType.LAZY)
    private List<Question> questions  ;

}
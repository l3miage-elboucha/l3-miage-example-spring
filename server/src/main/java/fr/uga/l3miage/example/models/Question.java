package fr.uga.l3miage.example.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String label ;

    // recuperation de chaque question toute seul et pas tous a la fois
    @ManyToOne(fetch = FetchType.LAZY)
    private Miahoot miahoot ;

    @OneToMany(mappedBy = "question")
    private List<Response> responses ;
}
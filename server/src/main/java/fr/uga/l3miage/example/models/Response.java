package fr.uga.l3miage.example.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String label ;

    private boolean estValide ;

    @ManyToOne
    private Question question;
}
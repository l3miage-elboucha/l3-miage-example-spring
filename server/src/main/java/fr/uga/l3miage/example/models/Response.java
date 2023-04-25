package fr.uga.l3miage.example.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    @Id
    @GeneratedValue
    private Long id ;
    private String label ;

    private boolean estValide ;

    @ManyToOne
    private Question question;
}
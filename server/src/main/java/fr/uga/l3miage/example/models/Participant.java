package fr.uga.l3miage.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("2")
@Getter
@Setter
@NoArgsConstructor
public class Participant extends Utilisateur {

    @ManyToOne
    private Miahoot participantMiahoot;
}
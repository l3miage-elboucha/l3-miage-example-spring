package fr.uga.l3miage.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("1")
@Getter
@Setter
@NoArgsConstructor
public class Teacher extends Utilisateur {

    @OneToMany(mappedBy = "concepteur")
    private List<Miahoot> createdMiahoots ;

    @OneToMany(mappedBy = "presentateur")
    private List<Miahoot> presentedMiahoots ;

}
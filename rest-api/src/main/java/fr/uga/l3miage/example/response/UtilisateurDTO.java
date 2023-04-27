package fr.uga.l3miage.example.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public abstract class UtilisateurDTO {
    String userName;
}

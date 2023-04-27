package fr.uga.l3miage.example.response;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class TeacherDTO extends UtilisateurDTO  {

    List<MiahootDTO> createdMiahoots ;
    List<MiahootDTO> presentedMiahoots ;

}
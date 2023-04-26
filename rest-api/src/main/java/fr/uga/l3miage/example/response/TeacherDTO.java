package fr.uga.l3miage.example.response;

import fr.uga.l3miage.example.models.Miahoot;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TeacherDTO {

    List<Miahoot> createdMiahoots ;
    List<Miahoot> presentedMiahoots ;

}

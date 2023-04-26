package fr.uga.l3miage.example.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TeacherDTO {

    List<MiahootDTO> createdMiahoots ;
    List<MiahootDTO> presentedMiahoots ;

}

package fr.uga.l3miage.example.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Null;
import java.util.List;

@SuperBuilder
@Getter
@Setter
public class TeacherDTO {
@Null
     List<MiahootDTO> createdMiahoots ;
/*@Null
     List<MiahootDTO> presentedMiahoots ;*/
}
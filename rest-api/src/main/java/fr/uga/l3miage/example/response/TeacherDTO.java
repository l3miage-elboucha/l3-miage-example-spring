package fr.uga.l3miage.example.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Null;
import java.util.List;

@Builder
@Getter
@Setter
public class TeacherDTO {
     Long id ;
     String nom ;
     @Null
     List<MiahootDTO> createdMiahoots ;
@Null
     List<MiahootDTO> presentedMiahoots ;
}
package fr.uga.l3miage.example.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class TeacherDTO {
     Long id;
     String nom;
     List<MiahootDTO> createdMiahoots ;
     List<MiahootDTO> presentedMiahoots ;
}
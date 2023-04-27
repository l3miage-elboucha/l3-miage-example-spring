package fr.uga.l3miage.example.request;


import fr.uga.l3miage.example.response.MiahootDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@Schema(description = "Correspond à la requête permettant de créer une entité Teacher")
public class CreateTeacherRequest {
    private Long id ;
     private String nom ;
    private  List<MiahootDTO> createdMiahoots ;
    private List<MiahootDTO> presentedMiahoots ;
}

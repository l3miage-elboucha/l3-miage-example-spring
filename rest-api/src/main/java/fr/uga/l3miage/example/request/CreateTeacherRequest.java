package fr.uga.l3miage.example.request;


import fr.uga.l3miage.example.response.MiahootDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CreateTeacherRequest {
    private Long id ;
     private String nom ;
    private  List<MiahootDTO> createdMiahoots ;
    private List<MiahootDTO> presentedMiahoots ;
}

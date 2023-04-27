package fr.uga.l3miage.example.request;


import fr.uga.l3miage.example.response.MiahootDTO;
import lombok.Builder;

import java.util.List;

@Builder
public class CreateTeacherRequest {
   private  List<MiahootDTO> createdMiahoots ;
    private List<MiahootDTO> presentedMiahoots ;
}

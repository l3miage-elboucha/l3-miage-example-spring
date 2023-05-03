package fr.uga.l3miage.example.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDTO {
     Long id ;
     String label ;
     boolean estValide ;
}

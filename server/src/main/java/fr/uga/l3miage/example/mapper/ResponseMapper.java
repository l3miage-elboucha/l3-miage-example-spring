package fr.uga.l3miage.example.mapper;


import fr.uga.l3miage.example.dto.ResponseDTO;
import fr.uga.l3miage.example.models.Question;
import fr.uga.l3miage.example.models.Response;
import org.mapstruct.Mapper;

@Mapper(uses = Response.class)
public interface ResponseMapper {

    Response  dtoToEntity(ResponseDTO responseDTO);
    ResponseDTO entityToDTO(Response response) ;
}

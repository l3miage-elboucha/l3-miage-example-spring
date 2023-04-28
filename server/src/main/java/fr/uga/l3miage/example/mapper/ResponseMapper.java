package fr.uga.l3miage.example.mapper;


import fr.uga.l3miage.example.request.CreateResponseRequest;
import fr.uga.l3miage.example.response.ResponseDTO;
import fr.uga.l3miage.example.models.Response;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponseMapper {

    Response  dtoToEntity(ResponseDTO responseDTO);
    Response  dtoToEntity(CreateResponseRequest request);
    ResponseDTO entityToDTO(Response response) ;
}

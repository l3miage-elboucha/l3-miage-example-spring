package fr.uga.l3miage.example.mapper;


import fr.uga.l3miage.example.response.ResponseDTO;
import org.apache.coyote.Response;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponseMapper {

    Response dtoToEntity(ResponseDTO responseDTO);
    ResponseDTO entityToDTO(Response response) ;
}

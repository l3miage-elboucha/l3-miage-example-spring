package fr.uga.l3miage.example.mapper;


import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.request.CreatMiahootRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MiahootMapper {
    MiahootDTO entitytoDto(Miahoot miahoot);
    Miahoot map(CreatMiahootRequest request);
    Miahoot dtoToEntity(MiahootDTO miahootDTO);

}


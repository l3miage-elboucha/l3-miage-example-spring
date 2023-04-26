package fr.uga.l3miage.example.mapper;


import fr.uga.l3miage.example.request.CreatMiahootRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.models.Miahoot;
import org.mapstruct.Mapper;

@Mapper(uses = Miahoot.class)
public interface MiahootMapper {
    MiahootDTO entitytoDto(Miahoot miahoot);
    Miahoot dtoToEntity(CreatMiahootRequest request);
}

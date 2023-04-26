package fr.uga.l3miage.example.mapper;


import fr.uga.l3miage.example.dto.MiahootDTO;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.TestEntity;
import fr.uga.l3miage.example.response.Test;
import org.mapstruct.Mapper;

@Mapper(uses = Miahoot.class)
public interface MiahootMapper {
    MiahootDTO entitytoDto(Miahoot miahoot);
    Miahoot dtoToEntity(MiahootDTO miahoot) ;
}

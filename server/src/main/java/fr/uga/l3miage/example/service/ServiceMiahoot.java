package fr.uga.l3miage.example.service;


import fr.uga.l3miage.example.component.MiahootComponent;
import fr.uga.l3miage.example.dto.MiahootDTO;
import fr.uga.l3miage.example.exception.rest.TestEntityNotFoundRestException;
import fr.uga.l3miage.example.exception.technical.TestEntityNotFoundException;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.repository.MiahootRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceMiahoot {

    private final MiahootRepository miahootRepository ;
    private final MiahootMapper miahootMapper;
    private final MiahootComponent miahootComponent ;


   /* public MiahootDTO getMiahoot(final Long miahootId) {
        try {
            return miahootMapper.EntitytoDto(miahootComponent.getMiahoot(miahootId));
        } catch (TestEntityNotFoundException ex) {
            throw new TestEntityNotFoundRestException(String.format("Impossible de charger l'entité.");
        }
    }*/
}

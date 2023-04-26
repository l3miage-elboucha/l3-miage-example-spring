package fr.uga.l3miage.example.service;


import fr.uga.l3miage.example.component.MiahootComponent;
import fr.uga.l3miage.example.exception.technical.*;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.repository.MiahootRepository;
import fr.uga.l3miage.example.request.CreatMiahootRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import fr.uga.l3miage.example.response.MiahootDTO;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ServiceMiahoot {
    private static final String ERROR_DETECTED = "Une erreur lors de la création de l'entité Miahoot à été détecté.";
    private final MiahootRepository miahootRepository ;
    private final MiahootMapper miahootMapper;
    private final MiahootComponent miahootComponent ;


 public MiahootDTO getMiahoot(final Miahoot miahoot) {
        try {
            return miahootMapper.entitytoDto(miahootComponent.getMiahoot(miahoot.getId()));
        } catch (MiahootEntityNotFoundException ex) {
            throw new MiahootEntityNotFoundException("Impossible de charger l'entité.",miahoot.getId());
        }
    }

    public void createMiahoot(final CreatMiahootRequest miahootRequest) throws MiahootAlreadyExistsException {
        Miahoot newMiahoot = miahootMapper.dtoToEntity(miahootRequest);
        try {
            miahootComponent.createMiahoot(newMiahoot);
            }catch (MiahootAlreadyExistsException ex) {
                throw new MiahootAlreadyExistsException(ERROR_DETECTED,newMiahoot.getId(),ex);
        }
    }

    @SneakyThrows
    @Transactional
    public void deleteMiahoot(Miahoot miahoot) throws MiahootEntityNotFoundException {
        if (miahoot != null) {
            miahootComponent.deleteMiahoot(miahoot);
        }else {
            throw  new MiahootEntityNotFoundException("Miahoot n'existe pas dèja", miahoot.getId());
        }

    }
}

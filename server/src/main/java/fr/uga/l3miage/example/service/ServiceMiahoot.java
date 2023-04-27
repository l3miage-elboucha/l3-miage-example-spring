package fr.uga.l3miage.example.service;


import fr.uga.l3miage.example.component.MiahootComponent;
import fr.uga.l3miage.example.exception.technical.MiahootAlreadyExistsException;
import fr.uga.l3miage.example.exception.technical.MiahootEntityNotFoundException;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.repository.MiahootRepository;
import fr.uga.l3miage.example.request.CreatMiahootRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ServiceMiahoot {
    private static final String ERROR_DETECTED = "Une erreur lors de la création de l'entité Miahoot à été détecté.";
    private final MiahootRepository miahootRepository ;
    private final MiahootMapper miahootMapper;
    private final MiahootComponent miahootComponent ;


 public MiahootDTO getMiahootById(final Long id) throws MiahootEntityNotFoundException {
        try {
            return miahootMapper.entitytoDto(miahootComponent.getMiahoot(id));
        } catch (MiahootEntityNotFoundException ex) {
            throw new MiahootEntityNotFoundException("Impossible de charger l'entité.", id);
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
    public void deleteMiahootById(Long miahootId) throws MiahootEntityNotFoundException {
        try {
            miahootComponent.deleteMiahootById(miahootId);
        } catch (MiahootEntityNotFoundException ex) {
            throw new MiahootEntityNotFoundException("Impossible de supprimer l'entité.", miahootId);
        }
    }

    @SneakyThrows
    @Transactional
    public void updateMiahootById(Long miahootId, MiahootDTO miahootDTO) throws MiahootEntityNotFoundException {
        try {
            miahootComponent.updateMiahootById(miahootId, miahootDTO);
        } catch (MiahootEntityNotFoundException ex) {
            throw new MiahootEntityNotFoundException("Impossible de mettre à jour l'entité.", miahootId);
        }
    }
}

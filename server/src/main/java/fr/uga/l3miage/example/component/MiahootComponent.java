package fr.uga.l3miage.example.component;


import fr.uga.l3miage.example.exception.technical.*;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.repository.MiahootRepository;
import fr.uga.l3miage.example.response.MiahootDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MiahootComponent {
    private final MiahootRepository miahootRepository;
    private final MiahootMapper miahootMapper;


    //Return Miahoot if it exists
    public Miahoot getMiahoot(final Long miahootId) throws MiahootEntityNotFoundException {
        return miahootRepository.findMiahootById(miahootId)
                .orElseThrow(() -> new MiahootEntityNotFoundException("Aucune entité n'a été trouvée avec cette ID ", miahootId));
    }

    //Create a new Miahoot if it doesn't exist
    public void createMiahoot(final Miahoot miahoot) throws MiahootAlreadyExistsException {

        if (miahootRepository.findMiahootById(miahoot.getId()).isPresent()) {
            throw new MiahootAlreadyExistsException("Miahoot existe déjà en BD. ", miahoot.getId());
        } else {
            miahootRepository.save(miahoot);
        }
    }

    //Delete Miahoot if it exists
    public void deleteMiahootById(final Long miahootId) throws MiahootEntityNotFoundException {
        Long deleted = miahootRepository.deleteMiahootById(miahootId);
        if (deleted == 0)
            throw new MiahootEntityNotFoundException("Aucune entité n'a été trouvée avec cette ID ", miahootId);

    }

    //Update Miahoot if it exists
    public void updateMiahootById(final Long miahootId, final MiahootDTO miahootDTO) throws MiahootEntityNotFoundException {
        if (miahootRepository.findMiahootById(miahootId).isPresent()) {
            miahootRepository.save(miahootMapper.dtoToEntity(miahootDTO));
        } else {
            throw new MiahootEntityNotFoundException("Aucune entité n'a été trouvée avec cette ID ", miahootId);
        }
    }

}





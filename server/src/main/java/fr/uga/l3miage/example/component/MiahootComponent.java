package fr.uga.l3miage.example.component;


import fr.uga.l3miage.example.exception.technical.*;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.repository.MiahootRepository;
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
    public void createMiahoot(final Miahoot miahoot) throws MiahootAlreadyExistException {

        if (miahootRepository.findMiahootById(miahoot.getId()).isPresent()) {
            throw new MiahootAlreadyExistException("Miahoot existe déjà en BD. ", miahoot.getId());
        } else {
            miahootRepository.save(miahoot);
        }
    }

    //Delete Miahoot if it exists
    public void deleteMiahoot(final Miahoot miahoot) throws MiahootEntityNotFoundException {
        Long deleted = miahootRepository.deleteMiahootById(miahoot.getId());
        if (deleted == 0)
            throw new MiahootEntityNotFoundException("Aucune entité n'a été trouvée avec cette ID ", miahoot.getId());

    }


}





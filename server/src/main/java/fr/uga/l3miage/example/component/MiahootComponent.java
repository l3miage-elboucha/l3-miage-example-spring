package fr.uga.l3miage.example.component;


import fr.uga.l3miage.example.exception.technical.TestEntityNotFoundException;
import fr.uga.l3miage.example.mapper.MiahootMapper;
import fr.uga.l3miage.example.mapper.TestMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.TestEntity;
import fr.uga.l3miage.example.repository.MiahootRepository;
import fr.uga.l3miage.example.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MiahootComponent {
    private final MiahootRepository miahootRepository;
    private final MiahootMapper miahootMapper;


   /* public Miahoot getMiahoot(final Long miahootId) throws TestEntityNotFoundException {
        return miahootRepository.findMiahootById(miahootId)
                .orElseThrow(() -> new TestEntityNotFoundException(String.format("Aucune entité n'a été trouvée pour la description [%s]", miahootId), miahootId));*/
    }


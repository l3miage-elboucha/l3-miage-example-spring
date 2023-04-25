package fr.uga.l3miage.example.repository;

import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.Teacher;
import fr.uga.l3miage.example.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiahootRepository extends JpaRepository<Miahoot,Long> {

    Miahoot findMiahootById(final Long miahootId) ;
    List<Miahoot> findMiahootByConcepteur(Teacher concepteur);
    void deleteMiahootById(final Long  miahootId);



}

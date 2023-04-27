package fr.uga.l3miage.example.repository;

import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher,String> {
    Optional<Teacher> findTeacherById(final Long id) ;
    void deleteTeacherById(final Long id);
}

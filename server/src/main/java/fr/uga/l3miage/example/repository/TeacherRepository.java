package fr.uga.l3miage.example.repository;

import fr.uga.l3miage.example.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher,String> {
    Optional<Teacher> findTeacherByFireBaseId(final String id) ;
    Teacher getTeachersByFireBaseId(String fireBaseId);

    void deleteTeacherById(final Long id);
}

package fr.uga.l3miage.example.service;

import fr.uga.l3miage.example.component


        .TeacherComponent;
import fr.uga.l3miage.example.request.CreateTeacherRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.TeacherDTO;
import fr.uga.l3miage.example.exception.technical.TeacherEntityNotFoundException;
import fr.uga.l3miage.example.exception.technical.TeacherAlreadyExistsException;
import fr.uga.l3miage.example.mapper.TeacherMapper;
import fr.uga.l3miage.example.models.Teacher;
import fr.uga.l3miage.example.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceTeacher {

    private static final String ERROR_DETECTED = "Une erreur lors de la création de l'entité Teacher à été détecté.";
    private final TeacherRepository teacherRepository ;
    private final TeacherMapper teacherMapper;
    private final TeacherComponent teacherComponent ;

    public TeacherDTO getTeacher(final Teacher teacher) {
        try {
            return teacherMapper.entityToDTO(teacherComponent.getTeacher(teacher.getFireBaseId()));
        } catch (TeacherEntityNotFoundException ex) {
            throw new TeacherEntityNotFoundException("Impossible de charger l'entité.");
        }
    }

    public TeacherDTO getTeacher(final String id) {
        try {
            return teacherMapper.entityToDTO(teacherComponent.getTeacher(id));
        } catch (TeacherEntityNotFoundException ex) {
            throw new TeacherEntityNotFoundException("Impossible de charger l'entité.");
        }
    }

    public TeacherDTO createTeacher(final CreateTeacherRequest teacherDTO) throws TeacherAlreadyExistsException {
        Teacher newTeacher = teacherMapper.dtoToEntity(teacherDTO);
        try {
            return teacherComponent.createTeacher(newTeacher);
        } catch (TeacherAlreadyExistsException ex) {
            throw new TeacherAlreadyExistsException(ERROR_DETECTED, newTeacher.getNom(), ex);
        }
    }

    public void updateTeacherUsername(final String id, final String newUsername) throws TeacherEntityNotFoundException {
        try {
            teacherComponent.updateTeacherUsername(id, newUsername);
        } catch (TeacherEntityNotFoundException ex) {
            throw new TeacherEntityNotFoundException("Impossible de charger l'entité.");
        }
    }

    public void deleteTeacher(final String id) throws TeacherEntityNotFoundException {
        try {
            teacherComponent.deleteTeacher(id);
        } catch (TeacherEntityNotFoundException ex) {
            throw new TeacherEntityNotFoundException("Impossible de charger l'entité.");
        }
    }

    public List<MiahootDTO> getMiahoots(final String id) throws TeacherEntityNotFoundException {
        try {
            return teacherComponent.getMiahoots(id);
        } catch (TeacherEntityNotFoundException ex) {
            throw new TeacherEntityNotFoundException("Impossible de charger l'entité.");
        }
    }

}

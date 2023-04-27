package fr.uga.l3miage.example.service;

import fr.uga.l3miage.example.component


        .TeacherComponent;
import fr.uga.l3miage.example.request.CreateTeacherRequest;
import fr.uga.l3miage.example.response.TeacherDTO;
import fr.uga.l3miage.example.exception.technical.TeacherEntityNotFoundException;
import fr.uga.l3miage.example.exception.technical.TeacherAlreadyExistsException;
import fr.uga.l3miage.example.mapper.TeacherMapper;
import fr.uga.l3miage.example.models.Teacher;
import fr.uga.l3miage.example.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceTeacher {

    private static final String ERROR_DETECTED = "Une erreur lors de la création de l'entité Teacher à été détecté.";
    private final TeacherRepository teacherRepository ;
    private final TeacherMapper teacherMapper;
    private final TeacherComponent teacherComponent ;

    public TeacherDTO getTeacher(final Teacher teacher) {
        try {
            return teacherMapper.entityToDTO(teacherComponent.getTeacher(teacher.getNom()));
        } catch (TeacherEntityNotFoundException ex) {
            throw new TeacherEntityNotFoundException("Impossible de charger l'entité.",teacher.getNom());
        }
    }

    public TeacherDTO getTeacher(final String userName) {
        try {
            return teacherMapper.entityToDTO(teacherComponent.getTeacher(userName));
        } catch (TeacherEntityNotFoundException ex) {
            throw new TeacherEntityNotFoundException("Impossible de charger l'entité.",userName);
        }
    }

    public void createTeacher(final CreateTeacherRequest teacherDTO) throws TeacherAlreadyExistsException {
        Teacher newTeacher = teacherMapper.dtoToEntity(teacherDTO);
        try {
            teacherComponent.createTeacher(newTeacher);
        } catch (TeacherAlreadyExistsException ex) {
            throw new TeacherAlreadyExistsException(ERROR_DETECTED, newTeacher.getNom(), ex);
        }
    }

    public void updateTeacherUsername(final String username, final String newUsername) throws TeacherEntityNotFoundException {
        try {
            teacherComponent.updateTeacherUsername(username, newUsername);
        } catch (TeacherEntityNotFoundException ex) {
            throw new TeacherEntityNotFoundException("Impossible de charger l'entité.", username);
        }
    }

    public void deleteTeacher(final String username) throws TeacherEntityNotFoundException {
        try {
            teacherComponent.deleteTeacher(username);
        } catch (TeacherEntityNotFoundException ex) {
            throw new TeacherEntityNotFoundException("Impossible de charger l'entité.", username);
        }
    }

}

/*
package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.exception.technical.TeacherAlreadyExistsException;
import fr.uga.l3miage.example.exception.technical.TeacherEntityNotFoundException;
import fr.uga.l3miage.example.mapper.TeacherMapper;
import fr.uga.l3miage.example.models.Miahoot;
import fr.uga.l3miage.example.models.Teacher;
import fr.uga.l3miage.example.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherComponent {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    //Return Teacher if it exists
    public Teacher getTeacher(final String username) throws TeacherEntityNotFoundException {
        return teacherRepository.findTeacherByUserName(username)
                .orElseThrow(() -> new TeacherEntityNotFoundException("Aucune entité n'a été trouvée avec ce Username ", username));
    }

    public void createTeacher(final Teacher teacher) throws TeacherAlreadyExistsException {
        if (teacherRepository.findTeacherByUserName(teacher.getUserName()).isPresent()) {
            throw new TeacherAlreadyExistsException("Username already taken ", teacher.getUserName());
        } else {
            teacherRepository.save(teacher);
        }
    }

    public void updateTeacherUsername(final String username, final String newUsername) throws TeacherEntityNotFoundException {
        Teacher teacher = teacherRepository.findTeacherByUserName(username)
                .orElseThrow(() -> new TeacherEntityNotFoundException("Aucune entité n'a été trouvée avec ce Username ", username));
        teacher.setUserName(newUsername);
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(final String username) throws TeacherEntityNotFoundException {
        Teacher teacher = teacherRepository.findTeacherByUserName(username)
                .orElseThrow(() -> new TeacherEntityNotFoundException("Aucune entité n'a été trouvée avec ce Username ", username));
        teacherRepository.delete(teacher);
    }

}
*/

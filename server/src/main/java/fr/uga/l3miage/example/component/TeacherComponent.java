package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.exception.technical.TeacherAlreadyExistsException;
import fr.uga.l3miage.example.exception.technical.TeacherEntityNotFoundException;
import fr.uga.l3miage.example.mapper.TeacherMapper;
import fr.uga.l3miage.example.models.Teacher;
import fr.uga.l3miage.example.repository.TeacherRepository;
import fr.uga.l3miage.example.response.MiahootDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TeacherComponent {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    //Return Teacher if it exists
    public Teacher getTeacher(final Long id) throws TeacherEntityNotFoundException {
        return teacherRepository.findTeacherById(id)
                .orElseThrow(() -> new TeacherEntityNotFoundException("Aucune entité n'a été trouvée avec ce Username ", id));
    }

    public void createTeacher(final Teacher teacher) throws TeacherAlreadyExistsException {
        if (teacherRepository.findTeacherById(teacher.getId()).isPresent()) {
            throw new TeacherAlreadyExistsException("Username already taken ", teacher.getNom());
        } else {
            teacherRepository.save(teacher);
        }
    }

    public void updateTeacherUsername(final Long id, final String newUsername) throws TeacherEntityNotFoundException {
        Teacher teacher = teacherRepository.findTeacherById(id)
                .orElseThrow(() -> new TeacherEntityNotFoundException("Aucune entité n'a été trouvée avec ce Username ", id));
        teacher.setNom(newUsername);
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(final Long id) throws TeacherEntityNotFoundException {
        Teacher teacher = teacherRepository.findTeacherById(id)
                .orElseThrow(() -> new TeacherEntityNotFoundException("Aucune entité n'a été trouvée avec ce Username ", id));
        teacherRepository.delete(teacher);
    }

    public List<MiahootDTO> getMiahoots(final Long id) throws TeacherEntityNotFoundException {
        Teacher teacher = teacherRepository.findTeacherById(id)
                .orElseThrow(() -> new TeacherEntityNotFoundException("Aucune entité n'a été trouvée avec ce Username ", id));
        return teacherMapper.mapToDto(teacher.getCreatedMiahoots());
    }

}

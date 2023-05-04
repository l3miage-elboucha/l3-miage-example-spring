package fr.uga.l3miage.example.component;

import fr.uga.l3miage.example.exception.technical.TeacherAlreadyExistsException;
import fr.uga.l3miage.example.exception.technical.TeacherEntityNotFoundException;
import fr.uga.l3miage.example.mapper.TeacherMapper;
import fr.uga.l3miage.example.models.Teacher;
import fr.uga.l3miage.example.repository.TeacherRepository;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.TeacherDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TeacherComponent {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    //Return Teacher if it exists
    public Teacher getTeacher(final String id) throws TeacherEntityNotFoundException {
        return teacherRepository.findTeacherByFireBaseId(id)
                .orElseThrow(() -> new TeacherEntityNotFoundException("Aucune entité n'a été trouvée avec ce Username "));
    }

    public TeacherDTO createTeacher(final Teacher teacher) throws TeacherAlreadyExistsException {
        if (teacherRepository.getTeachersByFireBaseId(teacher.getFireBaseId()) != null ) {
            throw new TeacherAlreadyExistsException("Tecaher does not exist ", teacher.getNom());
        } else {
            teacherRepository.save(teacher);
            return teacherMapper.entityToDTO(teacher);
        }
    }

    public void updateTeacherUsername(final String id, final String newUsername) throws TeacherEntityNotFoundException {
        Teacher teacher = teacherRepository.findTeacherByFireBaseId(id)
                .orElseThrow(() -> new TeacherEntityNotFoundException("Aucune entité n'a été trouvée avec ce Username "));
        teacher.setNom(newUsername);
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(final String id) throws TeacherEntityNotFoundException {
        Teacher teacher = teacherRepository.findTeacherByFireBaseId(id)
                .orElseThrow(() -> new TeacherEntityNotFoundException("Aucune entité n'a été trouvée avec ce Username "));
        teacherRepository.delete(teacher);
    }

    public List<MiahootDTO> getMiahoots(final String id) throws TeacherEntityNotFoundException {
        Teacher teacher = teacherRepository.findTeacherByFireBaseId(id)
                .orElseThrow(() -> new TeacherEntityNotFoundException("Aucune entité n'a été trouvée avec ce Username "));
        return teacherMapper.mapToDto(teacher.getCreatedMiahoots());
    }

}

package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.TeacherEndpoint;
import fr.uga.l3miage.example.exception.technical.TeacherAlreadyExistsException;
import fr.uga.l3miage.example.request.CreateTeacherRequest;
import fr.uga.l3miage.example.response.TeacherDTO;
import fr.uga.l3miage.example.service.ServiceTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeacherController implements TeacherEndpoint {
    private final ServiceTeacher serviceTeacher;
    @Override
    public TeacherDTO getTeacher(Long id){return serviceTeacher.getTeacher(id);}
    @Override
    public void createTeacher(CreateTeacherRequest request) {
        try {
            serviceTeacher.createTeacher(request);
        } catch (TeacherAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteTeacher(Long  id){serviceTeacher.deleteTeacher(id);}
}

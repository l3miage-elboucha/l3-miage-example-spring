package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.MiahootEndpoint;
import fr.uga.l3miage.example.exception.technical.MiahootAlreadyExistsException;
import fr.uga.l3miage.example.request.CreatMiahootRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.service.ServiceMiahoot;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
public class MiahootController implements MiahootEndpoint {

    private final ServiceMiahoot miahootService;

    @Override
    public MiahootDTO getMiahootById(Long id) {
        return miahootService.getMiahootById(id);
    }

    @Override
    public void createMiahoot(final CreatMiahootRequest request){
        try {
            miahootService.createMiahoot(request);
        } catch (MiahootAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteMiahootById(Long id) {
        miahootService.deleteMiahootById(id);
    }

    @Override
    public void updateMiahootById(Long id, MiahootDTO miahootDTO) {
        miahootService.updateMiahootById(id, miahootDTO);
    }


}

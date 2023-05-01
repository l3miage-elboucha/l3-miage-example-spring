package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.ResponseEndpoint;
import fr.uga.l3miage.example.request.CreateResponseRequest;
import fr.uga.l3miage.example.response.ResponseDTO;
import fr.uga.l3miage.example.service.ServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ResponseController implements ResponseEndpoint {
final private ServiceResponse serviceResponse ;

    @Override
    public ResponseDTO getResponseById(Long id) {
        return serviceResponse.getResponseById(id);
    }

    @Override
    public void createResponse(Long questionID, CreateResponseRequest question) {
        serviceResponse.createResponse(questionID,question);
    }

    @Override
    public void deleteResponse(Long id) {
    serviceResponse.deleteResponse(id);
    }

/*    @Override
    public void updateResponse(Long id, ResponseDTO responseDTO) {
        serviceResponse.updateResponseValid(id,responseDTO);
    }*/
}

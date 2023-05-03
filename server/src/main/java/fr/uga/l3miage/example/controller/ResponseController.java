package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.ResponseEndpoint;
import fr.uga.l3miage.example.request.CreateResponseRequest;
import fr.uga.l3miage.example.response.ResponseDTO;
import fr.uga.l3miage.example.service.ServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class ResponseController implements ResponseEndpoint {
final private ServiceResponse serviceResponse ;

    @Override
    public ResponseDTO getResponseById(Long id) {
        return serviceResponse.getResponseById(id);
    }

    @Override
    public List<ResponseDTO> getResponsesByQuestion(@PathVariable("questionId") Long questionId){ return serviceResponse.getResponsesByQuestion(questionId);}

    @Override
    public void createResponse(Long questionID, CreateResponseRequest question) {
        serviceResponse.createResponse(questionID,question);
    }

    @Override
    public void deleteResponse(Long id) {
    serviceResponse.deleteResponse(id);
    }

    @Override
    public void updateResponse(Long id,ResponseDTO response) {serviceResponse.updateResponse(id,response);}


}

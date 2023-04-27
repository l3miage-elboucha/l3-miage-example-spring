package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.ParticipantEndpoint;
import fr.uga.l3miage.example.request.CreateParticipantRequest;
import fr.uga.l3miage.example.response.ParticipantDTO;
import fr.uga.l3miage.example.service.ExampleService;
import fr.uga.l3miage.example.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ParticipantController implements ParticipantEndpoint{
    private final ParticipantService participantService;

    @Override
    public ParticipantDTO getParticipantDTO(String username){return participantService.getParticipant(username);
    }

    @Override
    public void createParticipantDTO(CreateParticipantRequest request){ participantService.createParticipant(request);}

    @Override
    public void deleteParticipantDTO(String username){participantService.deleteParticipant(username);}




}

package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.service.ExampleService;
import fr.uga.l3miage.example.service.ServiceMiahoot;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MiahootController {
    private final ServiceMiahoot serviceMiahoot;

}

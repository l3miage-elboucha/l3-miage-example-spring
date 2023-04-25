package fr.uga.l3miage.example.service;


import fr.uga.l3miage.example.repository.MiahootRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceMiahoot {

    private final MiahootRepository miahootRepository ;

}

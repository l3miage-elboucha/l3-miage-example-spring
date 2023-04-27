package fr.uga.l3miage.example.repository;

import fr.uga.l3miage.example.models.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response,Long> {

}

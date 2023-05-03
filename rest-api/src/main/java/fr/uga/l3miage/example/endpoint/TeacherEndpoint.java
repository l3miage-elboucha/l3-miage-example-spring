package fr.uga.l3miage.example.endpoint;

import fr.uga.l3miage.example.error.TestEntityNotDeletedErrorResponse;
import fr.uga.l3miage.example.error.TestNotFoundErrorResponse;
import fr.uga.l3miage.example.request.CreateTeacherRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.TeacherDTO;
import fr.uga.l3miage.example.response.Test;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Teacher tag")
@CrossOrigin
@RestController
@RequestMapping(value="api/teacher/",produces = "application/json")
public interface TeacherEndpoint {

    @GetMapping("{id}")
    @Operation(description = "Récupérer le teacherDTO qui a pour id celui passé en paramètre")
    @ApiResponse(responseCode = "200", description = "Renvoie le DTO de l'entité teacher demandée",
            content = @Content(schema = @Schema(implementation = Test.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si l'entité n'est pas trouvée",
            content = @Content(schema = @Schema(implementation = TestNotFoundErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    TeacherDTO getTeacher(@PathVariable Long id);


    @PostMapping
    @Operation(description = "Création d'une entité teacherDTO")
    @ApiResponse(responseCode = "201", description = "L'entité teacher a bien été créée.")
    @ResponseStatus(HttpStatus.CREATED)
    void createTeacher(@Valid @RequestBody CreateTeacherRequest request);

    @DeleteMapping("{id}")
    @Operation(description = "Suppression d'un teacher en bd")
    @ApiResponse(responseCode = "418", description = "Renvoie une erreur 418 si l'entité n'a pu être supprimée",
            content = @Content(schema = @Schema(implementation = TestEntityNotDeletedErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    void deleteTeacher(@PathVariable Long id);

    @GetMapping("{id}/miahoots")
    @Operation(description = "Récupérer les miahoots d'un teacher")
    @ApiResponse(responseCode = "200", description = "Renvoie les miahoots du teacher demandé")
    @ResponseStatus(HttpStatus.OK)
    List<MiahootDTO> getMiahoots(@PathVariable Long id);


}

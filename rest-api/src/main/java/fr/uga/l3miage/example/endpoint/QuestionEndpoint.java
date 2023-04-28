package fr.uga.l3miage.example.endpoint;

import fr.uga.l3miage.example.error.TestEntityNotDeletedErrorResponse;
import fr.uga.l3miage.example.error.TestNotFoundErrorResponse;
import fr.uga.l3miage.example.request.CreateQuestionRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.QuestionDTO;
import fr.uga.l3miage.example.response.Test;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Question tag")
@CrossOrigin
@RestController
@RequestMapping("api/question/")
public interface QuestionEndpoint {

    @GetMapping("{id}")
    @Operation(description = "Récupérer QuestionDTO qui a pour id celui passé en paramètre")
    @ApiResponse(responseCode = "200", description = "Renvoie le DTO de l'entité Question demandée",
            content = @Content(schema = @Schema(implementation = Test.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si l'entité n'est pas trouvée",
            content = @Content(schema = @Schema(implementation = TestNotFoundErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    QuestionDTO getQuestion(@PathVariable Long id);

    @PostMapping
    @Operation(description = "Création d'une entité QuestionDTO")
    @ApiResponse(responseCode = "201", description = "L'entité Question a bien été créée.")
    @ResponseStatus(HttpStatus.CREATED)
    void createQuestion(@Valid @RequestBody CreateQuestionRequest request);

    @DeleteMapping("{id}")
    @Operation(description = "Suppression d'une question en bd")
    @ApiResponse(responseCode = "200", description = "Suppression de l'entité Question demandée")
    @ApiResponse(responseCode = "418", description = "Renvoie une erreur 418 si l'entité n'a pu être supprimée",
            content = @Content(schema = @Schema(implementation = TestEntityNotDeletedErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    void deleteQuestion(@PathVariable Long id);

    @PutMapping("{id}")
    @Operation(summary = "Update a Question by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Question updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MiahootDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Question not found",
                    content = @Content) })

    void updateQuestion(@PathVariable("id") Long id, @RequestBody String newLabel);
}

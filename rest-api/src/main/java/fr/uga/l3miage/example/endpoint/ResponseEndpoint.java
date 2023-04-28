package fr.uga.l3miage.example.endpoint;

import fr.uga.l3miage.example.error.TestEntityNotDeletedErrorResponse;
import fr.uga.l3miage.example.error.TestNotFoundErrorResponse;
import fr.uga.l3miage.example.request.CreateResponseRequest;
import fr.uga.l3miage.example.response.ResponseDTO;
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

@Tag(name = "Response tag")
@CrossOrigin
@RestController
@RequestMapping("api/responses/")
public interface ResponseEndpoint {

    @GetMapping("{id}")
    @Operation(description = "Récupérer ResponseDTO qui a pour id celui passé en paramètre")
    @ApiResponse(responseCode = "200", description = "Renvoie le DTO de l'entité demandée",
            content = @Content(schema = @Schema(implementation = Test.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si l'entité n'est pas trouvée",
            content = @Content(schema = @Schema(implementation = TestNotFoundErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    ResponseDTO getResponseById(@PathVariable("id") Long id);

    @PostMapping()
    @Operation(description = "Création d'une entité ResponseDTO")
    @ApiResponse(responseCode = "201", description = "L'entité Response a bien été créée.")
    @ResponseStatus(HttpStatus.CREATED)
    void createResponse(@Valid @RequestBody CreateResponseRequest request);

    @DeleteMapping("{id}")
    @Operation(description = "Suppression d'une réponse en bd")
    @ApiResponse(responseCode = "200", description = "L'entité Response a bien été supprimée.")
    @ApiResponse(responseCode = "418", description = "Renvoie une erreur 418 si l'entité n'a pu être supprimée",
            content = @Content(schema = @Schema(implementation = TestEntityNotDeletedErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    void deleteResponse(@PathVariable Long id);

    @PutMapping("{id}")
    @Operation(description = "Modification d'une réponse en bd")
    @ApiResponse(responseCode = "200", description = "L'entité Response a bien été modifiée.")
    @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si l'entité n'a pu être modifiée",
            content = @Content(schema = @Schema(implementation = TestNotFoundErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    void updateResponse(@PathVariable Long id, @Valid @RequestBody ResponseDTO responseDTO);

}

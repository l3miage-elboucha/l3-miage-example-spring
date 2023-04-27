package fr.uga.l3miage.example.endpoint;


import fr.uga.l3miage.example.request.CreatMiahootRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Miahoot tag")
@CrossOrigin
@RestController
@RequestMapping("miahoot/")
public interface MiahootEndpoint {

    /* Ici on définit un endpoint en mode <b>GET</b> qui nous renvoie un Miahoot */

    @GetMapping("{id}")
    @Operation(summary = "Get a Miahoot by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Miahoot",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MiahootDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Miahoot not found",
                    content = @Content) })

    MiahootDTO getMiahootById(@PathVariable("id") Long id);

    /* Ici on définit un endpoint en mode <b>POST</b> qui nous renvoie un Miahoot */

    @PostMapping
    @Operation(summary = "Create a Miahoot")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Miahoot created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MiahootDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Miahoot",
                    content = @Content) })

    void createMiahoot(@Valid @RequestBody CreatMiahootRequest request);

    /* Ici on définit un endpoint en mode <b>DELETE<b> pour supprimer une entité Miahoot */

    @DeleteMapping("{id}")
    @Operation(summary = "Delete a Miahoot by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Miahoot deleted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MiahootDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Miahoot not found",
                    content = @Content) })

    void deleteMiahootById(@PathVariable("id") Long id);

    /* Ici on définit un endpoint en mode <b>PUT</b> pour mettre à jour une entité Miahoot */

    @PutMapping("{id}")
    @Operation(summary = "Update a Miahoot by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Miahoot updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MiahootDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Miahoot not found",
                    content = @Content) })

    void updateMiahootById(@PathVariable("id") Long id, @RequestBody MiahootDTO miahootDTO);


}

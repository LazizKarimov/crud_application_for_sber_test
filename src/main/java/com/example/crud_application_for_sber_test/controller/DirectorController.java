package com.example.crud_application_for_sber_test.controller;

import com.example.crud_application_for_sber_test.dto.DirectorDTO;
import com.example.crud_application_for_sber_test.service.DirectorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling operations related to directors.
 */
@RequestMapping("/director")
@RestController
public class DirectorController {
    private final DirectorService directorService;

    /**
     * Constructor for DirectorController.
     *
     * @param directorService The service for director operations.
     */
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    /**
     * Endpoint for creating a new director.
     *
     * @param directorDTO The DTO representing the director to be created.
     * @return The DTO of the created director.
     */
    @PostMapping
    public DirectorDTO createDirector(@RequestBody DirectorDTO directorDTO) {
        return directorService.save(directorDTO);
    }

    /**
     * Endpoint for updating an existing director.
     *
     * @param directorDTO The DTO representing the updated director information.
     * @return The DTO of the updated director.
     */
    @PutMapping
    public DirectorDTO updateDirector(@RequestBody DirectorDTO directorDTO) {
        return directorService.update(directorDTO);
    }

    /**
     * Endpoint for deleting a director by id.
     *
     * @param id The id of the director to be deleted.
     */
    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable Long id) {
        directorService.delete(id);
    }

    /**
     * Endpoint for retrieving all directors.
     *
     * @return A list of DTOs representing all directors.
     */
    @GetMapping
    public List<DirectorDTO> getAllDirectors() {
        return directorService.getAll();
    }

    /**
     * Endpoint for retrieving a director by id.
     *
     * @param id The id of the director to retrieve.
     * @return The DTO representing the director with the specified id.
     */
    @GetMapping("/{id}")
    public DirectorDTO getDirectorById(@PathVariable Long id) {
        return directorService.getById(id);
    }
}

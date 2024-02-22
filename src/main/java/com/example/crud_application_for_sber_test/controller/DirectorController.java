package com.example.crud_application_for_sber_test.controller;

import com.example.crud_application_for_sber_test.dto.DirectorDTO;
import com.example.crud_application_for_sber_test.service.DirectorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/director")
@RestController
public class DirectorController {
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PostMapping
    public DirectorDTO createDirector(@RequestBody DirectorDTO directorDTO) {
        return directorService.save(directorDTO);
    }

    @PutMapping
    public DirectorDTO updateDirector(@RequestBody DirectorDTO directorDTO) {
        return directorService.update(directorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable Long id) {
        directorService.delete(id);
    }

    @GetMapping
    public List<DirectorDTO> getAllDirectors() {
        return directorService.getAll();
    }

    @GetMapping("/{id}")
    public DirectorDTO getDirectorById(@PathVariable Long id) {
        return directorService.getById(id);
    }
}

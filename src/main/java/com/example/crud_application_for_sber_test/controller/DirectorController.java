package com.example.crud_application_for_sber_test.controller;

import com.example.crud_application_for_sber_test.dto.DirectorDTO;
import com.example.crud_application_for_sber_test.service.DirectorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/director")
@RestController
public class DirectorController {
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PostMapping
    public DirectorDTO createDirector(@RequestBody DirectorDTO directorDTO ) {
        return directorService.save(directorDTO);
    }

}

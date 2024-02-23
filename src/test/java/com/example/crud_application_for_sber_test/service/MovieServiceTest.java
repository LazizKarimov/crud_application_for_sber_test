package com.example.crud_application_for_sber_test.service;

import com.example.crud_application_for_sber_test.dto.MovieDTO;
import com.example.crud_application_for_sber_test.entity.Director;
import com.example.crud_application_for_sber_test.repository.DirectorRepository;
import com.example.crud_application_for_sber_test.repository.MovieRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MovieServiceTest {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private MovieService movieService;

    @AfterEach
    void clear() {
        movieRepository.deleteAll();
        directorRepository.deleteAll();
    }

    @Test
    void save() {
        // Arrange
        Director director = Director.builder()
                .name("Tom")
                .lastName("Pak")
                .age(37)
                .build();
        director.setId(directorRepository.save(director).getId());

        MovieDTO movieDTO = MovieDTO.builder()
                .name("testName")
                .year(1990)
                .director(director)
                .build();

        // Act
        MovieDTO savedMovieDTO = movieService.save(movieDTO);
        movieDTO.setId(savedMovieDTO.getId());

        // Assert
        assertEquals(movieDTO, savedMovieDTO);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }
}
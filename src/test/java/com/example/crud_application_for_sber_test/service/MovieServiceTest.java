package com.example.crud_application_for_sber_test.service;

import com.example.crud_application_for_sber_test.dto.MovieDTO;
import com.example.crud_application_for_sber_test.entity.Director;
import com.example.crud_application_for_sber_test.repository.DirectorRepository;
import com.example.crud_application_for_sber_test.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for MovieServiceTest.
 */
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

    /**
     * Tests the save method of the MovieService class.
     */
    @Test
    void save_movieDTO_savedSuccessfully() {
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

    /**
     * Tests the update method of the MovieService class.
     */
    @Test
    void update_movieDTO_updatedSuccessfully() {
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

        movieService.save(movieDTO);

        MovieDTO newMovieDTO = MovieDTO.builder()
                .id(movieDTO.getId())
                .name("changedName")
                .year(2000)
                .director(director)
                .build();

        // Act
        MovieDTO updatedMovieDTO = movieService.update(newMovieDTO);

        // Assert
        assertEquals("changedName", updatedMovieDTO.getName());
        assertEquals(2000, updatedMovieDTO.getYear());
    }

    /**
     * Tests the delete method of the MovieService class.
     */
    @Test
    void delete_movie_deletedSuccessfully() {
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

        movieService.save(movieDTO);

        // Act
        movieService.delete(movieDTO.getId());

        // Assert
        assertNull(movieRepository.findById(movieDTO.getId()).orElse(null));
    }

    /**
     * Tests the getAll method of the MovieService class.
     */
    @Test
    void getAll_movies_returnedSuccessfully() {
        // Arrange
        Director director1 = Director.builder()
                .name("Tom")
                .lastName("Pak")
                .age(37)
                .build();
        director1.setId(directorRepository.save(director1).getId());

        MovieDTO movieDTO1 = MovieDTO.builder()
                .name("testName1")
                .year(1990)
                .director(director1)
                .build();
        movieService.save(movieDTO1);

        Director director2 = Director.builder()
                .name("Jane")
                .lastName("Pak")
                .age(37)
                .build();
        director2.setId(directorRepository.save(director2).getId());

        MovieDTO movieDTO2 = MovieDTO.builder()
                .name("testName2")
                .year(1990)
                .director(director2)
                .build();
        movieService.save(movieDTO2);

        // Act
        List<MovieDTO> movieDTOS = movieService.getAll();

        // Assert
        assertEquals(2, movieDTOS.size());
        assertEquals("testName1", movieDTOS.get(0).getName());
        assertEquals("testName2", movieDTOS.get(1).getName());
    }

    /**
     * Tests the getById method of the MovieService class with an existing movie ID.
     */
    @Test
    void getById_existingMovieId_movieReturned() {
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

        movieService.save(movieDTO);

        // Act
        MovieDTO result = movieService.getById(director.getId());

        // Assert
        assertNotNull(result);
        assertEquals("testName", result.getName());
        assertEquals(1990, result.getYear());
    }

    /**
     * Tests the getById method of the MovieService class with a non-existing movie ID.
     */
    @Test
    void getById_nonExistingMovieId_entityNotFoundExceptionThrown() {
        // Arrange
        Long id = 1L;

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> movieService.getById(id));
    }
}
package com.example.crud_application_for_sber_test.service;

import com.example.crud_application_for_sber_test.dto.DirectorDTO;
import com.example.crud_application_for_sber_test.entity.Director;
import com.example.crud_application_for_sber_test.repository.DirectorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test class for DirectorService.
 */
@SpringBootTest
class DirectorServiceTest {
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private DirectorService directorService;

    /**
     * Clears the repository after each test.
     */
    @AfterEach
    void clear() {
        directorRepository.deleteAll();
    }

    /**
     * Test for saving DirectorDTO.
     */
    @Test
    void save_directorDTO_savedSuccessfully() {
        // Arrange
        DirectorDTO directorDTO = DirectorDTO.builder()
                .name("John")
                .lastName("Doe")
                .age(30)
                .build();

        // Act
        DirectorDTO savedDirectorDTO = directorService.save(directorDTO);

        directorDTO.setId(savedDirectorDTO.getId());
        // Assert
        assertEquals(directorDTO, savedDirectorDTO);
    }

    /**
     * Test for updating DirectorDTO.
     */
    @Test
    void update_directorDTO_updatedSuccessfully() {
        // Arrange
        DirectorDTO directorDTO = DirectorDTO.builder()
                .name("John")
                .lastName("Doe")
                .age(30)
                .build();
        directorDTO.setId(directorService.save(directorDTO).getId());

        DirectorDTO updatedDTO = DirectorDTO.builder()
                .id(directorDTO.getId())
                .name("UpdatedName")
                .lastName("UpdatedLastName")
                .age(35)
                .build();

        // Act
        DirectorDTO updatedDirectorDTO = directorService.update(updatedDTO);

        // Assert
        assertEquals("UpdatedName", updatedDirectorDTO.getName());
        assertEquals("UpdatedLastName", updatedDirectorDTO.getLastName());
        assertEquals(35, updatedDirectorDTO.getAge());
    }

    /**
     * Test for deleting DirectorDTO.
     */
    @Test
    void delete_director_deletedSuccessfully() {
        // Arrange
        DirectorDTO directorDTO = DirectorDTO.builder()
                .name("John")
                .lastName("Doe")
                .age(30)
                .build();
        directorDTO.setId(directorService.save(directorDTO).getId());
        Long id = directorDTO.getId();

        // Act
        directorService.delete(id);

        // Assert
        assertNull(directorRepository.findById(id).orElse(null));
    }

    /**
     * Test for getting all DirectorDTOs.
     */
    @Test
    void getAll_directors_returnedSuccessfully() {
        // Arrange
        Director director1 = Director.builder().name("John").lastName("Doe").age(30).build();
        Director director2 = Director.builder().name("Jane").lastName("Doe").age(28).build();

        List<Director> directors = Arrays.asList(director1, director2);
        director1.setId(directorRepository.save(directors.get(0)).getId());
        director2.setId(directorRepository.save(directors.get(1)).getId());

        // Act
        List<DirectorDTO> directorDTOs = directorService.getAll();

        // Assert
        assertEquals(2, directorDTOs.size());
        assertEquals("John", directorDTOs.get(0).getName());
        assertEquals("Jane", directorDTOs.get(1).getName());
    }

    /**
     * Test for getting DirectorDTO by ID.
     */
    @Test
    void getById_existingDirectorId_directorReturned() {
        // Arrange
        Director director = Director.builder()
                .name("John")
                .lastName("Doe")
                .age(30)
                .build();
        director.setId(directorRepository.save(director).getId());

        // Act
        DirectorDTO directorDTO = directorService.getById(director.getId());

        // Assert
        assertNotNull(directorDTO);
        assertEquals("John", directorDTO.getName());
        assertEquals("Doe", directorDTO.getLastName());
        assertEquals(30, directorDTO.getAge());
    }

    /**
     * Test for getting DirectorDTO by non-existing ID.
     */
    @Test
    void getById_nonExistingDirectorId_entityNotFoundExceptionThrown() {
        // Arrange
        Long id = 1L;

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> directorService.getById(id));
    }
}
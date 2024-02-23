package com.example.crud_application_for_sber_test.service;

import com.example.crud_application_for_sber_test.dto.DirectorDTO;
import com.example.crud_application_for_sber_test.entity.Director;
import com.example.crud_application_for_sber_test.mapper.DirectorMapper;
import com.example.crud_application_for_sber_test.repository.DirectorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class for managing Director entity.
 */
@Service
@Slf4j
public class DirectorService {
    private final DirectorMapper directorMapper;
    private final DirectorRepository directorRepository;

    public DirectorService(DirectorMapper directorMapper, DirectorRepository directorRepository) {
        this.directorMapper = directorMapper;
        this.directorRepository = directorRepository;
    }

    /**
     * Saves a DirectorDTO object as a Director entity.
     *
     * @param directorDTO The DirectorDTO object to save.
     * @return The saved DirectorDTO object.
     */
    @Transactional
    public DirectorDTO save(DirectorDTO directorDTO) {
        log.info("Saving director: {}", directorDTO.getName());
        Director director = directorMapper.convertToEntity(directorDTO);
        directorDTO.setId(directorRepository.save(director).getId());
        return directorDTO;
    }

    /**
     * Updates a DirectorDTO object as a Director entity.
     *
     * @param directorDTO The DirectorDTO object to update.
     * @return The updated DirectorDTO object.
     */
    @Transactional
    public DirectorDTO update(DirectorDTO directorDTO) {
        log.info("Updating director with id: {}", directorDTO.getId());
        Director existingDirector = directorRepository.findById(directorDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Director with id " + directorDTO.getId() + " not found"));

        existingDirector.setName(directorDTO.getName());
        existingDirector.setLastName(directorDTO.getLastName());
        existingDirector.setAge(directorDTO.getAge());

        return directorMapper.convertToDTO(directorRepository.save(existingDirector));
    }

    /**
     * Deletes a Director entity by its ID.
     *
     * @param id The ID of the Director entity to delete.
     */
    @Transactional
    public void delete(Long id) {
        log.info("Deleting director with id: {}", id);
        directorRepository.deleteById(id);
    }

    /**
     * Retrieves a list of all DirectorDTO objects.
     *
     * @return The list of DirectorDTO objects.
     */
    @Transactional
    public List<DirectorDTO> getAll() {
        log.info("Getting all directors");
        List<Director> directors = directorRepository.findAll();
        return directorMapper.convertToDTOList(directors);
    }

    /**
     * Retrieves a DirectorDTO object by its ID.
     *
     * @param id The ID of the Director entity to retrieve.
     * @return The DirectorDTO object.
     */
    @Transactional
    public DirectorDTO getById(Long id) {
        log.info("Getting director with id: {}", id);
        return directorRepository.findById(id)
                .map(directorMapper::convertToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Director with id " + id + " not found"));
    }
}

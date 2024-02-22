package com.example.crud_application_for_sber_test.service;

import com.example.crud_application_for_sber_test.dto.DirectorDTO;
import com.example.crud_application_for_sber_test.entity.Director;
import com.example.crud_application_for_sber_test.mapper.DirectorMapper;
import com.example.crud_application_for_sber_test.repository.DirectorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DirectorService {
    private static final Logger logger = LoggerFactory.getLogger(DirectorService.class);
    private final DirectorMapper directorMapper;
    private final DirectorRepository directorRepository;

    public DirectorService(DirectorMapper directorMapper, DirectorRepository directorRepository) {
        this.directorMapper = directorMapper;
        this.directorRepository = directorRepository;
    }

    @Transactional
    public DirectorDTO save(DirectorDTO directorDTO) {
        logger.info("Saving director: {}", directorDTO.getName());
        Director director = directorMapper.convertToEntity(directorDTO);
        directorDTO.setId(directorRepository.save(director).getId());
        return directorDTO;
    }

    @Transactional
    public DirectorDTO update(DirectorDTO directorDTO) {
        logger.info("Updating director with id: {}", directorDTO.getId());
        Director existingDirector = directorRepository.findById(directorDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Director with id " + directorDTO.getId() + " not found"));

        existingDirector.setName(directorDTO.getName());
        existingDirector.setLastName(directorDTO.getLastName());
        existingDirector.setAge(directorDTO.getAge());

        return directorMapper.convertToDTO(directorRepository.save(existingDirector));
    }

    @Transactional
    public void delete(Long id) {
        logger.info("Deleting director with id: {}", id);
        directorRepository.deleteById(id);
    }

    public List<DirectorDTO> getAll() {
        logger.info("Getting all directors");
        List<Director> directors = directorRepository.findAll();
        return directorMapper.convertToDTOList(directors);
    }

    @Transactional
    public DirectorDTO getById(Long id) {
        logger.info("Getting director with id: {}", id);
        return directorRepository.findById(id)
                .map(directorMapper::convertToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Director with id " + id + " not found"));
    }
}

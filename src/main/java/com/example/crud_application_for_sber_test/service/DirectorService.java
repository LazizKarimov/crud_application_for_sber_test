package com.example.crud_application_for_sber_test.service;

import com.example.crud_application_for_sber_test.dto.DirectorDTO;
import com.example.crud_application_for_sber_test.entity.Director;
import com.example.crud_application_for_sber_test.mapper.DirectorMapper;
import com.example.crud_application_for_sber_test.repository.DirectorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    private final DirectorMapper directorMapper;
    private final DirectorRepository directorRepository;

    public DirectorService(DirectorMapper directorMapper, DirectorRepository directorRepository) {
        this.directorMapper = directorMapper;
        this.directorRepository = directorRepository;
    }

    public DirectorDTO save(DirectorDTO directorDTO) {
        Director director = directorMapper.convertToEntity(directorDTO);
        directorDTO.setId(directorRepository.save(director).getId());
        return directorDTO;
    }

    public DirectorDTO update(DirectorDTO directorDTO) {
        Director existingDirector = directorRepository.findById(directorDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Director with id " + directorDTO.getId() + " not found"));

        existingDirector.setName(directorDTO.getName());
        existingDirector.setLastName(directorDTO.getLastName());
        existingDirector.setAge(directorDTO.getAge());

        return directorMapper.convertToDTO(directorRepository.save(existingDirector));
    }

    public void delete(Long id) {
        directorRepository.deleteById(id);
    }

    public List<DirectorDTO> getAll() {
        List<Director> directors = directorRepository.findAll();
        return directorMapper.convertToDTOList(directors);
    }

    public DirectorDTO getById(Long id) {
        return directorRepository.findById(id)
                .map(directorMapper::convertToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Director with id " + id + " not found"));
    }
}

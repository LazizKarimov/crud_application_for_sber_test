package com.example.crud_application_for_sber_test.service;

import com.example.crud_application_for_sber_test.dto.DirectorDTO;
import com.example.crud_application_for_sber_test.entity.Director;
import com.example.crud_application_for_sber_test.mapper.DirectorMapper;
import com.example.crud_application_for_sber_test.repository.DirectorRepository;
import org.springframework.stereotype.Service;

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
}

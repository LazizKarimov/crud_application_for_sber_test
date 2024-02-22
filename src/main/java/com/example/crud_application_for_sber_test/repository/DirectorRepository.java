package com.example.crud_application_for_sber_test.repository;

import com.example.crud_application_for_sber_test.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}

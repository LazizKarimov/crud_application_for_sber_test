package com.example.crud_application_for_sber_test.repository;


import com.example.crud_application_for_sber_test.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Movie entities.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}

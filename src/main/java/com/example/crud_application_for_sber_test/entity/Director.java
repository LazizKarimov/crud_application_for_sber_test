package com.example.crud_application_for_sber_test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a director.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "director")
@Builder
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // The unique identifier of the director.

    @Column(name = "name")
    private String name; // The first name of the director.

    @Column(name = "last_name")
    private String lastName; // The last name of the director.

    @Column(name = "age")
    private Integer age; // The age of the director.

//    @OneToMany(mappedBy = "movieDirector")
//    private List<Movie> listOfMovies;
}

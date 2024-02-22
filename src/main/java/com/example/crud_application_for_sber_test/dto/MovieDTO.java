package com.example.crud_application_for_sber_test.dto;

import com.example.crud_application_for_sber_test.entity.Director;
import lombok.Data;

@Data
public class MovieDTO {
    private Long id;
    private String name;
    private int year;
//    @JsonProperty("director_id")
    private Director director;
}

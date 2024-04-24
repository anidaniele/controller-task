package org.example.controllertask.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateSchoolDTO {
    private Long id;
    private String name;
    private List<StudentDTO> students;
}

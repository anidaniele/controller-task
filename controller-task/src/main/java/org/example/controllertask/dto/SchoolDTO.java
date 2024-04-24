package org.example.controllertask.dto;

import lombok.Data;

import java.util.List;

@Data
public class SchoolDTO {
    private Long id;
    private String name;
    private List<StudentDTO> students;
}

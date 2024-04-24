package org.example.controllertask.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long studentId;
    private String name;
    private String surname;
    private String email;
}

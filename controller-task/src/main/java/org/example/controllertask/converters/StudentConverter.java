package org.example.controllertask.converters;

import org.example.controllertask.dto.StudentDTO;
import org.example.controllertask.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentConverter {

    public static StudentDTO convertStudentToDTO(Student student){
        StudentDTO dto = null;
        if (student != null){
            dto = new StudentDTO();
            dto.setStudentId(student.getStudentId());
            dto.setName(student.getName());
            dto.setSurname(student.getSurname());
            dto.setEmail(student.getEmail());
        }
        return dto;
    }

    public static List<StudentDTO> convertStudentListToDTO(List<Student> students){
        List<StudentDTO> dtoList = null;
        if (students != null && !students.isEmpty()){
            dtoList = new ArrayList<>();
            for (Student student: students){
                dtoList.add(StudentConverter.convertStudentToDTO(student));
            }
        }
        return dtoList;
    }

    public static Student convertCreateStudentDTOToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setStudentId(dto.getStudentId());
        student.setName(dto.getName());
        student.setSurname(dto.getSurname());
        student.setEmail(dto.getEmail());
        return student;
    }
}

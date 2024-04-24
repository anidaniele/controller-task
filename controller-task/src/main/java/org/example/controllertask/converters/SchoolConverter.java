package org.example.controllertask.converters;

import org.example.controllertask.dto.CreateSchoolDTO;
import org.example.controllertask.dto.SchoolDTO;
import org.example.controllertask.entities.School;

import java.util.ArrayList;
import java.util.List;

public class SchoolConverter {

    public static SchoolDTO convertSchoolToDTO(School school){
        SchoolDTO dto = null;
        if (school != null){
            dto = new SchoolDTO();
            dto.setId(school.getId());
            dto.setName(school.getName());
            dto.setStudents(school.getStudents()
                    .stream()
                    .map(StudentConverter::convertStudentToDTO)
                    .toList());
        }
        return dto;
    }

    public static List<SchoolDTO> convertSchoolListToDTO(List<School> schools){
        List<SchoolDTO> dtoList = null;
        if (schools != null && !schools.isEmpty()){
            dtoList = new ArrayList<>();
            for (School school: schools){
                dtoList.add(SchoolConverter.convertSchoolToDTO(school));
            }
        }
        return dtoList;
    }

    public static School convertSchoolDTOToEntity(CreateSchoolDTO schoolDTO){
        School school = null;
        if (schoolDTO != null){
            school = new School();
            school.setId(schoolDTO.getId());
            school.setName(schoolDTO.getName());
            school.setStudents(schoolDTO.getStudents().stream()
                    .map(StudentConverter::convertCreateStudentDTOToEntity)
                    .toList());
        }
        return school;
    }
}

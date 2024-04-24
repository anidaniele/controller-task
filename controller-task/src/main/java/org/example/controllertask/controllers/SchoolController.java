package org.example.controllertask.controllers;

import lombok.RequiredArgsConstructor;
import org.example.controllertask.converters.SchoolConverter;
import org.example.controllertask.converters.StudentConverter;
import org.example.controllertask.dto.CreateSchoolDTO;
import org.example.controllertask.dto.SchoolDTO;
import org.example.controllertask.dto.StudentDTO;
import org.example.controllertask.entities.Student;
import org.example.controllertask.services.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/schools")
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping
    public List<SchoolDTO> getAllSchools() {
        return SchoolConverter.convertSchoolListToDTO(schoolService.getAllSchools());
    }

    @GetMapping(value = "/{id}")
    public SchoolDTO getSchoolById(@PathVariable Long id) {
        return SchoolConverter.convertSchoolToDTO(schoolService.getSchoolByIdOrThrow(id));
    }

    @GetMapping(value = "/{id}/students")
    public List<StudentDTO> getStudentsBySchooldId(@PathVariable Long id){
        return StudentConverter.convertStudentListToDTO(schoolService.getSchoolByIdOrThrow(id).getStudents());
    }

    @GetMapping(value = "/{schoolId}/students/{studentId}")
    public Student getStudentByStudentId(@PathVariable Long schoolId, @PathVariable Long studentId){
        return this.schoolService.getStudentByStudentIdAndSchoolId(schoolId, studentId);
    }

    @PostMapping
    public void addSchool(@RequestBody CreateSchoolDTO schoolDTO) {
        schoolService.addNewSchool(SchoolConverter.convertSchoolDTOToEntity(schoolDTO));
    }

    @PostMapping(value = "/{schoolId}/students")
    public void addStudent(@PathVariable Long schoolId, @RequestBody StudentDTO studentDTO) {
        schoolService.createStudentBySchoolId(schoolId, studentDTO);

    }

    @PatchMapping("/{schoolId}")
    public void updateSchoolNameById(@PathVariable Long schoolId, @RequestBody CreateSchoolDTO schoolDTO) {
        schoolService.updateSchoolNameById(schoolId, schoolDTO.getName());
    }




}

package org.example.controllertask.controllers;

import lombok.RequiredArgsConstructor;
import org.example.controllertask.entities.School;
import org.example.controllertask.entities.Student;
import org.example.controllertask.services.SchoolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/schools")
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping
    public List<School> getAllSchools() {
        return this.schoolService.getAllSchools();
    }

    @GetMapping(value = "/{id}")
    public School getSchoolById(@PathVariable Long id) {
        return this.schoolService.getSchoolByIdOrThrow(id);
    }

    @GetMapping(value = "/{id}/students")
    public List<Student> getStudentsBySchooldId(@PathVariable Long id){
        return this.schoolService.getSchoolByIdOrThrow(id).getStudents();
    }

    @GetMapping(value = "/{schoolId}/students/{studentId}")
    public Student getStudentByStudentId(@PathVariable Long schoolId, @PathVariable Long studentId){
        return this.schoolService.getStudentByStudentIdAndSchoolId(schoolId, studentId);

    }




}

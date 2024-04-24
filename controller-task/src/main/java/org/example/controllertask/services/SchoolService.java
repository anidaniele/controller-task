package org.example.controllertask.services;

import lombok.AllArgsConstructor;
import org.example.controllertask.dto.StudentDTO;
import org.example.controllertask.entities.School;
import org.example.controllertask.entities.Student;
import org.example.controllertask.repositories.SchoolRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SchoolService {
    private SchoolRepository schoolRepository;

    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }

    public School getSchoolByIdOrThrow(Long id){
        Optional<School> school = schoolRepository.findById(id);
        if (school.isEmpty()) {
            throw new ObjectNotFoundException(id, "School not found");
        }
        return school.get();
    }

    public Student getStudentByStudentIdAndSchoolId(Long schoolId, Long studentId) {
        return getSchoolByIdOrThrow(schoolId)
                .getStudents()
                .stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new ObjectNotFoundException(studentId, "Student not found"));
    }

    public void addNewSchool(School school){
        schoolRepository.save(school);
        System.out.println("School added successfully");

    }

    public void createStudentBySchoolId(Long schoolId, StudentDTO studentDTO) {
        School school = getSchoolByIdOrThrow(schoolId);
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setSurname(studentDTO.getSurname());
        student.setEmail(studentDTO.getEmail());
        school.getStudents().add(student);
        schoolRepository.save(school);
    }

    public School updateSchoolNameById(Long schoolId, String name) {
        School school = getSchoolByIdOrThrow(schoolId);
        school.setName(name);
        return schoolRepository.save(school);
    }

}

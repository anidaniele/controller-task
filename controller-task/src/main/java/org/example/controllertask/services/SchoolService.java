package org.example.controllertask.services;

import lombok.AllArgsConstructor;
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

}

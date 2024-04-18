package org.example.controllertask.services;

import jakarta.annotation.PostConstruct;
import org.example.controllertask.entities.School;
import org.example.controllertask.entities.Student;
import org.example.controllertask.repositories.SchoolRepository;
import org.springframework.stereotype.Service;

@Service
public class TestDataInitializer {

    private final SchoolRepository schoolRepository;

    public TestDataInitializer(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostConstruct
    public void initTestData() {
        // Create a school
        School school = new School();
        school.setId(1L);
        school.setName("First School");
        schoolRepository.save(school);

        School school2 = new School();
        school2.setId(2L);
        school2.setName("Second School");
        schoolRepository.save(school2);

        // Create and add students to the school's student list
        Student student1 = new Student();
        student1.setName("John");
        student1.setSurname("Doe");
        student1.setEmail("john@example.com");
        school.getStudents().add(student1);

        Student student2 = new Student();
        student2.setName("Jane");
        student2.setSurname("Doe");
        student2.setEmail("jane@example.com");
        school.getStudents().add(student2);

        Student student3 = new Student();
        student3.setName("James");
        student3.setSurname("Wilson");
        student3.setEmail("jameswilson@example.com");
        school.getStudents().add(student3);

        Student student4 = new Student();
        student4.setName("Olivia");
        student4.setSurname("Davis");
        student4.setEmail("oliviadavis@example.com");
        school2.getStudents().add(student4);

        Student student5 = new Student();
        student5.setName("Emily");
        student5.setSurname("Smith");
        student5.setEmail("emilysmith@example.com");
        school2.getStudents().add(student5);

        schoolRepository.save(school);
        schoolRepository.save(school2);
    }

}

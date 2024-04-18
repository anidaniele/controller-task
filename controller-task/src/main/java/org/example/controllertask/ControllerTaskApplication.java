package org.example.controllertask;

import lombok.AllArgsConstructor;
import org.example.controllertask.services.TestDataInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class ControllerTaskApplication {

    //private TestDataInitializer testDataInitializer;

    public static void main(String[] args) {
        SpringApplication.run(ControllerTaskApplication.class, args);
    }

    //public void addData() {testDataInitializer.initTestData();}


}

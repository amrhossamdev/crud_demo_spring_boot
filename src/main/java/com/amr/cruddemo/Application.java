package com.amr.cruddemo;

import com.amr.cruddemo.dao.StudentDAO;
import com.amr.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Create new student");

        Student temp = new Student("Amr", "Hossam", "amrhossam.dev@gmail.com");
        // save the student object
        System.out.println("Saving....");
        studentDAO.save(temp);

        // display id of the saved student
        System.out.println("Done saved" + temp.getId());

    }
}

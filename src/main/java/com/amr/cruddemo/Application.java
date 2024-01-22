package com.amr.cruddemo;

import com.amr.cruddemo.dao.StudentDAO;
import com.amr.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);
            //findStudent(studentDAO);
            //queryForStudent(studentDAO);
            //queryForFindByLastName(studentDAO);
            //updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            deleteAll(studentDAO);
        };
    }

    private void deleteAll(StudentDAO studentDAO) {
        int rows = studentDAO.deleteAll();
        System.out.println("Number deleted " + rows);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentID = 1;
        Student student = studentDAO.findById(studentID);
        student.setFirstName("Mohamed");
        studentDAO.update(student);
    }

    private void queryForFindByLastName(StudentDAO studentDAO) {
        List<Student> result = studentDAO.findByFirstName("Amr3");
        for (Student student : result) {
            System.out.println(student.toString());
        }

    }

    private void queryForStudent(StudentDAO studentDAO) {
        List<Student> result = studentDAO.findAll();
        for (Student st : result) {
            System.out.println(st);
        }
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Create new student");

        Student temp = new Student("Amr", "Hossam", "amrhossam.dev@gmail.com");
        // save the student object
        System.out.println("Saving....");
        studentDAO.save(temp);

        // display id of the saved student
        System.out.println("Done saved " + temp.getId());

    }

    private void findStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findById(4);
        if (student != null) {
            System.out.println("Found a student !" + student);
        }
    }


}

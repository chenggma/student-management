package com.guicheng.student_management.service;

import com.guicheng.student_management.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Cheng_01", 18),
            new Student(2, "Cheng_02", 19),
            new Student(3, "Cheng_03", 20)
    ));

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}

package com.guicheng.student_management.mapper;

import com.guicheng.student_management.dto.StudentDto;
import com.guicheng.student_management.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student) {   // entity → DTO
        return new StudentDto(
                student.getId(),      // ① id
                student.getFirstName(),      // ② firstName
                student.getLastName(),      // ③ lastName
                student.getEmail()       // ④ email
        );
    }

    public static Student mapToStudent(StudentDto studentDto) {    // DTO → entity
        return new Student(             // ⑤ which class are we creating?
                studentDto.getId(),   // ⑥–⑨ the same four getters, called on the DTO
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail()
        );
    }
}

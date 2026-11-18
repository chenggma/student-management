package com.guicheng.student_management.mapper;

import com.guicheng.student_management.dto.StudentDto;
import com.guicheng.student_management.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student) {   // entity → DTO
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    public static Student mapToStudent(StudentDto studentDto) {    // DTO → entity
        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail()
        );
    }
}

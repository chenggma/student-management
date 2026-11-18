package com.guicheng.student_management.service.impl;

import com.guicheng.student_management.dto.StudentDto;
import com.guicheng.student_management.entity.Student;
import com.guicheng.student_management.exception.ResourceNotFoundException;
import com.guicheng.student_management.mapper.StudentMapper;
import com.guicheng.student_management.repository.StudentRepository;
import com.guicheng.student_management.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);       // ① DTO → entity
        Student savedStudent = studentRepository.save(student);         // ② save it
        return StudentMapper.mapToStudentDto(savedStudent);              // ③ entity → DTO
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)          // ① find by id → returns Optional
                .orElseThrow(() -> new ResourceNotFoundException(          // ② your exception class
                        "Student does not exist with given id: " + studentId));
        return StudentMapper.mapToStudentDto(student);                    // ③ entity → DTO
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();     // ① get all from the database
        return students.stream()                                   // ② turn it into a stream
                .map(StudentMapper::mapToStudentDto)              // ③ how to convert one Student
                .toList();                                         // ④ collect back into a List
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Student does not exist with given id: " + studentId));

        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());

        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Student does not exist with given id: " + studentId));

        studentRepository.deleteById(studentId);
    }
}

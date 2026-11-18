package com.guicheng.student_management.repository;

import com.guicheng.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {   // ⑥ entity type   ⑦ type of the id
}

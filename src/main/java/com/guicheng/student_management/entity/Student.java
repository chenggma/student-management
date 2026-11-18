package com.guicheng.student_management.entity;

import jakarta.persistence.*;

@Entity                               // ① "this class maps to a table"
@Table(name = "students")                 // ② the table name (see the naming table)
public class Student {
    @Id                                   // ③ "this is the primary key"
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // the database numbers it 1, 2, 3...
    private Long id;

    @Column(name = "first_name")          // ④ column name: lowercase + underscore
    private String firstName;

    @Column(name = "last_name")          // ⑤
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)   // required, and no duplicates
    private String email;

    public Student() {
    }



    public Student(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

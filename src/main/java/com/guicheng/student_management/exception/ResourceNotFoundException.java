package com.guicheng.student_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)        // ① which status? look at the HttpStatus constants: "not found"
public class ResourceNotFoundException extends RuntimeException {   // ② unchecked → which parent class?

    public ResourceNotFoundException(String message) {
        super(message);                                  // ③ pass the message to the parent's constructor
    }
}

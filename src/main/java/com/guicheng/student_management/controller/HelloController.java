package com.guicheng.student_management.controller;
// imports: don't type these, IntelliJ adds them (see below)

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")        // ② annotation for the METHOD + ③ the URL path, in quotes
    public String hello() {    // ④ return type: you're returning a sentence
        return "hello!";       // ⑤ any sentence you like
    }
}

package com.example.subjects.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping({"/", "/hello"})
    public String hello() {
        return "hello";
    }
}

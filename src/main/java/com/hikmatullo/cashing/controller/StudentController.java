package com.hikmatullo.cashing.controller;

import com.hikmatullo.cashing.entity.Student;
import com.hikmatullo.cashing.service.StudentService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentService.findById(id);
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        return studentService.update(id, student);
    }


    @PostMapping("/cookie")
    public String getCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("sample_example", "message_from_controller");
        response.addCookie(cookie);
        return "Cookie";
    }
}

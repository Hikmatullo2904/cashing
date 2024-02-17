package com.hikmatullo.cashing.service;

import com.hikmatullo.cashing.entity.Student;
import com.hikmatullo.cashing.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;


    public Student save(Student student){
        return studentRepository.save(student);
    }

    @Cacheable(value = "students", key = "#id")
    public Student findById(Integer id){

       return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

    }

    @CacheEvict(value = "students", key = "#id")
    public void deleteById(Integer id){
        studentRepository.deleteById(id);
    }

    @CachePut(value = "students", key = "#id")
    public Student update(Integer id, Student student){
        student.setId(id);
        return studentRepository.save(student);
    }
}

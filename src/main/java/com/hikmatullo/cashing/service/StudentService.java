package com.hikmatullo.cashing.service;

import com.hikmatullo.cashing.entity.Student;
import com.hikmatullo.cashing.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    private final ConcurrentHashMap<Integer, Student> hashMap = new ConcurrentHashMap<>();

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public Student findById(Integer id){
        if(hashMap.containsKey(id)){
            return hashMap.get(id);
        }
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        hashMap.put(id, student);
        return student;
    }

    public void deleteById(Integer id){
        hashMap.remove(id);
        studentRepository.deleteById(id);
    }

    public Student update(Integer id, Student student){
        student.setId(id);
        hashMap.put(id, student);
        return studentRepository.save(student);
    }
}

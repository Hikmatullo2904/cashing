package com.hikmatullo.cashing.repo;

import com.hikmatullo.cashing.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}

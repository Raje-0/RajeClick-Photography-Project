package com.raje.restRespository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raje.restEntity.Student;

public interface StudentDao extends JpaRepository<Student, Long> {
}
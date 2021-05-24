package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.handle.BusinessException;

public interface StudentService {
    Student getStudentById(Long id) throws BusinessException, Exception;
}

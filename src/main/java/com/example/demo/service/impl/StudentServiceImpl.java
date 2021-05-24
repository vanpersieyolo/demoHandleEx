package com.example.demo.service.impl;

import com.example.demo.Contants.MessageResponse;
import com.example.demo.entity.Student;
import com.example.demo.handle.BusinessException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student getStudentById(Long id) throws BusinessException , Exception{
        if (!StringUtils.isEmpty(id)) {
            Optional<Student> student = studentRepository.findById(id);
            return student.orElse(null);
        } else {
            throw new BusinessException(MessageResponse.DATA_VALID);
        }
    }
}

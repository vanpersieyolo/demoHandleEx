package com.example.demo.controller;

import com.example.demo.Contants.MessageResponse;
import com.example.demo.commons.Enums;
import com.example.demo.commons.ResponseData;
import com.example.demo.entity.Student;
import com.example.demo.handle.BusinessException;
import com.example.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.LoggingUtils;

@RestController
@RequestMapping("api/v1/home")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping("/get-detail-student-by-id")
    public ResponseData getDetailStudentById(@RequestParam(value = "id") Long id){
        logger.info("ID: " + id);
        if (StringUtils.isEmpty(id)){
            return new ResponseData(Enums.ResponseStatus.ERROR, MessageResponse.DATA_VALID);
        }
        try {
            Student student = studentService.getStudentById(id);
            return new ResponseData(Enums.ResponseStatus.SUCCESS,student);
        } catch (BusinessException e) {
            logger.error(e.getMessage());
            return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), e.getMessage());
        } catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), e.getMessage());
        }
    }


}

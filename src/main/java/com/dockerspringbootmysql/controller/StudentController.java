package com.dockerspringbootmysql.controller;

//import com.dockerspringbootmysql.entity.Student;
//import com.dockerspringbootmysql.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class StudentController {
//    @Autowired
//    private StudentRepo studentRepo;


//    @GetMapping("/findAll")
//    public List<Student> getAllStudent(){
//        return studentRepo.findAll();
//    }

    @GetMapping("")
    public String get(){
        return "teste";
    }

//    @PostMapping("/insert")
//    public Student insert(@RequestBody Student student){
//        return studentRepo.save(student);
//    }
}

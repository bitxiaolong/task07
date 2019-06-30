package com.controller;


import com.pojo.Student;
import com.service.StudentMapperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    private  static final Logger log = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentMapperService studentMapperService;

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public ModelAndView selectStudent(ModelAndView modelAndView){
        //查全表，根据工资降序排列
        List<Student> studentList = studentMapperService.select();
        //取全部结果的前四个放入新的list当中
        List<Student> students = new ArrayList<>();
        for (int a=0;a<4;a ++){
            students.add(studentList.get(a));
        }
        log.info("列表的长度为："+students.size()+"-----"+"工资排名前四的是："+students);
        modelAndView.addObject("students",students);
        modelAndView.setViewName("student");
        return modelAndView;
    }
}

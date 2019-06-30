package com.service.impl;

import com.dao.StudentMapper;
import com.pojo.Student;
import com.service.StudentMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentMapperServiceimpl implements StudentMapperService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> select() {
        //调用查询方法，取出表中降序排列的薪资
        List<Student> studentList = studentMapper.select();

        //再将取出来的薪资放入新的list之中
        List<Student> students = new ArrayList<>();
        for (int a=0;a<4;a++){
            students.add(studentList.get(a));
        }
        return  students;
    }
}

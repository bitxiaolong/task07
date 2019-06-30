package com.controller;


import com.pojo.Job;
import com.service.JobMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobMapperService jobMapperService;

    @RequestMapping(value = "/job",method = RequestMethod.GET)
    public ModelAndView selectJob(){
        List<Job> selecta = jobMapperService.select();
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("jobList",selecta);
        modelAndView.setViewName("job");
        return modelAndView;
    }
}

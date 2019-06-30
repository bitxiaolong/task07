package com.service.impl;

import com.dao.JobMapper;
import com.pojo.Job;
import com.service.JobMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobMapperServiceImpl implements JobMapperService {
    @Autowired
    private JobMapper jobMapper;

    @Override
    public List<Job> select() {
        return this.jobMapper.select();
    }
}

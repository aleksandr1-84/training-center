package com.rest.projectexample.services.impl;

import com.rest.projectexample.services.ExamplleService;
import com.rest.projectexample.to.ExampleTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExamplleServiceImpl implements ExamplleService{
    private static final Logger LOG = LoggerFactory.getLogger(ExamplleServiceImpl.class);
    
    @Override
    public ExampleTO fillExampleGet(String key, String name, String info){
        ExampleTO exampleTO = new ExampleTO();
        exampleTO.setKey(key);
        exampleTO.setExampleInfo(info);
        return exampleTO;
    }
    
    @Override
    public ExampleTO fillExamplePost(ExampleTO exampleTO){
        exampleTO.setExampleInfo("fillPost");
        return exampleTO;
    }
}

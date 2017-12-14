package com.rest.projectexample.services;

import com.rest.projectexample.to.ExampleTO;

public interface ExamplleService {
    public ExampleTO fillExampleGet(String key, String name, String info);
    public ExampleTO fillExamplePost(ExampleTO exampleTO);
}
